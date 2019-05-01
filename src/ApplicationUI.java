import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

/**
 * A text based user interface for the database.
 * It has the following functions:
 * The start menu, where you select which of the program's functions to run
 * The add item menu, where you add a new item according the the type of material
 * The search menu, where you can make specific searches in the inventory
 *
 * @author Arild Valderhaug & Arne Styve
 * @version 1.0
 */
public class ApplicationUI
{
    // instance variables - replace the example below with your own
    private String[] menuItems = {
            "1. List all items",
            "2. Add new item",
            "3. Find item(s)",
    };
    private String[] addMenuItems = {
            "1. Add book",
            "2. Add new book series",
            "3. Add book to series",
            "4. Add newspaper",
            "5. Add magazine",
            "6. Add comic book",
    };
    private String[] searchMenuItems = {
            "1. Search by title",
            "2. List by publisher",
    };
    private Inventory inventory;

    /**
     * Creates an instance of the applicationUI.
     */
    public ApplicationUI()
    {
        this.inventory = new Inventory();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        //this.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection)
                {
                    case 1:
                        this.listAllItems();
                        break;

                    case 2:
                        int addSelection = this.showMenu(addMenuItems);
                        this.addNewItem(addSelection);
                        break;

                    case 3:
                        int searchSelection = this.showMenu(searchMenuItems);
                        switch (searchSelection){
                            case 1:
                                findItemByString();
                                break;

                            case 2:
                                listPublisher();
                                break;
                        }
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.9. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays a menu to the user, which is determined by the menu array that is inputted,
     * and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu(String[] refMenuItems) throws InputMismatchException
    {
        System.out.println("\n**** Application v0.9 ****\n");
        // Display the menu
        for ( String refMenuItem : refMenuItems )
        {
            System.out.println(refMenuItem);
        }
        int maxMenuItemNumber = refMenuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---

    /**
     * Using the getIterator method of the Inventory object, lists all items in the inventory
     */

    private void listAllItems()
    {
        Iterator<PrintMaterial> it = this.inventory.getIterator();
        int i = 0;
        while (it.hasNext())
        {
           PrintMaterial mat = it.next();

           printDetails(mat);

            i++;
        }
        System.out.println("Total: " + i + " item(s).");
    }

    /**
     * Add a new item to the collection.
     * Collects all data required to create a new class.
     * Creates a new instance of the given class and adds the new object to the collection.
     * If the selection is #3, add book to series, no new object is created, but an existing book is added to a book series.
     * @param selection is the menu item number selected by the user, corresponding to the type of material to be added.
     */
    private void addNewItem(int selection)
    {
        // Ask for book title
        String title = inputString("title");
        String publisher = inputString("publisher");

        // creates a new instance of Book and adds it to inventory
        if (selection == 1)
        {
            String author = inputString("author");
            int edition = inputInt("edition");
            Book book = new Book(title, author, publisher, edition);
            this.inventory.addItem(book);
            System.out.println("Book added.");
        }
        // creates a new instance of BookSeries and adds it to inventory
        if (selection == 2)
        {
                BookSeries bookSeries = new BookSeries(title, publisher);
                this.inventory.addItem(bookSeries);
        }

        if (selection == 3)
        {
            addBookToSeries(title, publisher);
        }
        // creates a new instance of the periodical specified.
        else if (selection == 4 || selection == 5 || selection == 6)
        {
            int editions = inputInt("editions per year");
            String genre = inputString("genre");
            if (selection == 4)
            {
                Newspaper newspaper = new Newspaper(title, publisher, editions, genre);
                this.inventory.addItem(newspaper);
                System.out.println("Newspaper added.");
            }
            else if (selection == 5)
            {
                Magazine magazine = new Magazine(title, publisher, editions, genre);
                this.inventory.addItem(magazine);
                System.out.println("Magazine added.");
            }
            else if (selection == 6)
            {
                ComicBook comicBook = new ComicBook(title, publisher, editions, genre);
                this.inventory.addItem(comicBook);
                System.out.println("Comic book added.");
            }
        }
    }

    /**
     * Adds a book to a book series. Search for book by title and series by title.
     * If both are found, add the book to the series.
     * @param title the title of the book to search for
     * @param publisher the publisher to search for
     */
    private void addBookToSeries(String title, String publisher)
    {
        String seriesTitle = inputString("series title:");
        PrintMaterial book = this.inventory.findItemByString(title, publisher);
        if(book instanceof Book)
        {
            Book b = (Book) book;
            PrintMaterial series = this.inventory.findItemByString(seriesTitle, publisher);
            if(series instanceof BookSeries)
            {
                BookSeries bookSeries = (BookSeries) series;
                bookSeries.addItem(b);
                System.out.println("Book added to series");
            }
            else
            {
                System.out.println("Book series not found.");
            }
        }
        else
        {
            System.out.println("Book not found.");
        }
    }
    /**
     * Find and display an item based on title and publisher, if known.
     * Gets the information for title and publisher through the inputString method.
     * Makes a call to the findItemByString method of the Inventory object, which returns
     * a PrintMaterial object if successful, or a null object if not.
     */
    private void findItemByString()
    {
        // Collect search strings
        String title = inputString("item title");
        String pub = inputString("publisher.");

        PrintMaterial printMat = this.inventory.findItemByString(title, pub);

        if (printMat != null) {
            System.out.println("Item found: ");
            printDetails(printMat);
        }
        else {
            System.out.println("No items found.");
        }
    }

    /**
     *  List all items by a given publisher. Gets the name of the publisher through the
     *  inputString method.
     *  Using the inventory's getIterator method, compares the search string to each material
     *  If the search string matches the publisher, prints the details of that material.
     */
    private void listPublisher()
    {
        String pub = inputString("publisher");
        Iterator<PrintMaterial> it = this.inventory.getIterator();
        int i = 0;
        while (it.hasNext())
        {
            PrintMaterial mat = it.next();
            if (mat.getPublisher().equals(pub))
            {
                printDetails(mat);

                i++;
            }

        }
        if(i > 0) {
            System.out.println("Total: " + i + " item(s).");
        }
         else
        {
            System.out.println("No items found.");
        }
    }

    // methods assisting in the operation of the program

    /**
     * A method for collecting a string from the user. Ensures the string is valid before returning.
     * @param string Informs the user what information is required.
     * @return returns a valid string
     * @throws BlankInputException if the input is blank
     */
    private String inputString(String string)
    {
        String inputString = new String();
        Scanner reader = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput)
        {
            try
            {
                //Ask for author
                System.out.println("Please enter " + string + ": ");
                //Read input from user
                inputString = reader.nextLine();
                if (inputString.trim().length() == 0) {
                    throw new BlankInputException("Field cannot be empty.");
                } else {
                    validInput = true;
                }
            }
            catch (BlankInputException e)
            {
                System.out.println("Field cannot be empty.");
            }
        }
        return inputString;
    }

    /**
     * A method for collecting a int value from the user. Ensures the int value is valid before returning.
     * @param string Intended to inform the user what information is requested. String is printed
     *               along with the user prompt.
     * @return A valid int value
     * @throws InputMismatchException if the int value is less than or equal to zero
     */
    private int inputInt(String string)
    {
        int inputInt = 0;
        boolean validInput = false;

        while(!validInput)
        {
            try {
                Scanner reader = new Scanner(System.in);
                //Ask for author
                System.out.println("Please enter " + string + ": ");
                //Read input from user
                inputInt = reader.nextInt();
                if(inputInt <= 0){
                    throw new InputMismatchException("Invalid value");
                }
                else
                {
                    validInput = true;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid number.");
            }
        }
        return inputInt;
    }

    /**
     * Initiates the detail printing of the specific material. This method casts from PrintMaterial
     * to the specific sub-class of the material. It then calls the relevant methods to print the details
     * of the material.
      * @param material The material whose details are to be printed.
     */
    private void printDetails(PrintMaterial material) {
        if (material instanceof Book) {
            Book b = (Book) material;
            printBookDetails(b);
        } else if (material instanceof BookSeries) {
            BookSeries s = (BookSeries) material;
            printBookSeriesDetails(s);
        } else if (material instanceof Periodical)
        {
            Periodical p = (Periodical) material;
            printPeriodicalDetails(p);
        }
        else
        {
            System.out.println("Print material not recognized");
        }
    }

    /**
     * Prints the details of the Book object passed.
     * @param book the book whose details are to be printed
     */
    private void printBookDetails(Book book)
        {
            System.out.println("Title: " +  book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Publisher: " + book.getPublisher() + ", Edition: " + book.getEdition());
        }

    /**
     * Prints the details of the book series passed.
     * Prints the title of the book series on the first line, followed by an indented list of each book
     * and it's details.
     * @param series the book series whose details are to be printed
     */
    private void printBookSeriesDetails(BookSeries series)
        {
            System.out.println("Series: " + series.getTitle());
            Iterator<Book> it = series.getBookSeriesIterator();
            while(it.hasNext())
            {
                Book book = it.next();
                System.out.println("   " + "Title: " +  book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Publisher: " + book.getPublisher() + ", Edition: " + book.getEdition());
            }
        }

    /**
     * Prints the details of the periodical passed.
     * Since all periodicals contain the same variables, one method for printing the details
     * of the superclass is used instead of multiple identical methods for each subclass of
     * Periodical.
     * @param periodical the periodical whose details are to be printed
     */
    private void printPeriodicalDetails(Periodical periodical)
        {
            System.out.println("Title: " + periodical.getTitle() + ", Publisher: " +
                    periodical.getPublisher() + ", Genre: " + periodical.getGenre());
        }
}