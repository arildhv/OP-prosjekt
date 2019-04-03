import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

/**
 * A text based user interface for the database.
 * It has the following functions:
 * -List all items in a specific database
 * -Add new items to the database
 * -Search for specific items in a database
 *
 * @author Arild Valderhaug & Arne Styve
 * @version 0.9
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
            "2. Add book to series",
            "3. Add newspaper",
            "4. Add magazine",
            "5. Add comic book",
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
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
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
     * Displays a menu to the user, which is determined by the menu array this is inputted,
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
     * Lists all items in the inventory
     */

    private void listAllItems()
    {
        Iterator<PrintMaterial> it = this.inventory.getIterator();
        int i = 0;
        while (it.hasNext())
        {
           PrintMaterial mat = it.next();

           System.out.println(mat.getDetails());

            i++;
        }
        System.out.println("Total: " + i + " item(s).");
    }

    /**
     * Add a new item to the collection.
     * Collects all data required to create a new class.
     * Creates a new instance of the given class, and adds the new object to the collection.
     * @param selection is the menu item number selected by the user
     */
    private void addNewItem(int selection)
    {
        // Ask for book title
        String title = inputString("title");
        String publisher = inputString("publisher");

        if (selection == 1 || selection == 2){
            String author = inputString("author");
            int edition = inputInt("edition");
            if (selection == 1) {
                Book book = new Book(title, author, publisher, edition);
                this.inventory.addItem(book);
                System.out.println("Book added.");
            }
            else if (selection == 2){
                String seriesName = inputString("series name");
                int published = inputInt("publication year");
                BookSeries bookSeries = new BookSeries(title, publisher, author, edition, seriesName, published);
                this.inventory.addItem(bookSeries);
            }
        }
        else if (selection == 3 || selection == 4 || selection == 5) {
            int editions = inputInt("editions per year");
            String genre = inputString("genre");
            if (selection == 3) {
                Newspaper newspaper = new Newspaper(title, publisher, editions, genre);
                this.inventory.addItem(newspaper);
                System.out.println("Newspaper added.");
            } else if (selection == 4) {
                Magazine magazine = new Magazine(title, publisher, editions, genre);
                this.inventory.addItem(magazine);
                System.out.println("Magazine added.");
            } else if (selection == 5) {
                ComicBook comicBook = new ComicBook(title, publisher, editions, genre);
                this.inventory.addItem(comicBook);
                System.out.println("Comic book added.");
            }
        }
    }

    /**
     * Find and display an item based on title and publisher, if known.
     */
    private void findItemByString()
    {
        // Collect search strings
        String title = inputString("item title");
        String pub = inputString("publisher. If unknown, leave blank.");

        PrintMaterial printMat = this.inventory.findItemByString(title, pub);

        if (printMat != null) {
            System.out.println("Book found: ");
            System.out.println(printMat.getDetails());
        }
        else {
            System.out.println("No items found.");
        }
    }

    /**
     *  List all items by a given publisher
     */
    private void listPublisher()
    {
        //Ask for publisher
        String pub = inputString("publisher");

        this.inventory.listByPublisher(pub);
    }

    // methods for collecting input values when creating new objects
    private String inputString(String string)
    {
        Scanner reader = new Scanner(System.in);
        //Ask for author
        System.out.println("Please enter " + string + ": ");
        //Read input from user
        return reader.nextLine();
    }

    private int inputInt(String string)
    {
        Scanner reader = new Scanner(System.in);
        //Ask for author
        System.out.println("Please enter " + string + ": ");
        //Read input from user
        return reader.nextInt();
    }
}