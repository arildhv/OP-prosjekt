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
 * @version 0.1
 */
public class ApplicationUI
{
    // instance variables - replace the example below with your own
    private String[] menuItems = {
            "1. List all books",
            "2. Add new book",
            "3. Find a book",
    };

    private BookCollection books;

    /**
     * Creates an instance of the applicationUI.
     */
    public ApplicationUI()
    {
        this.books = new BookCollection();
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
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.findBookByName();
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
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
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
     * Lists all books in the collection
     */
    void listAllBooks()
    {
        Iterator<Book> it = this.books.getIterator();
        int i = 0;
        while (it.hasNext())
        {
            Book b = it.next();
            System.out.println("Title: " + b.getTitle() + ", "
                    + "Author: " + b.getAuthor() + ", "
                    + "Publisher: " + b.getPublisher() + ", "
                    + "Edition: " + b.getEdition());
            i++;
        }

        System.out.println("Total: " + i + " book(s).");
    }

    /**
     * Add a new books to the collection.
     * Creates a new instance of the book class, and adds the new object to the collection.
     */
    void addNewBook()
    {
        // Ask for book title
        System.out.println("Please enter book title: ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();

        // Ask for book author
        System.out.println("Please enter book author: ");
        // Read input from user
        String author = reader.nextLine();

        // Ask for publisher
        System.out.println("Please enter book publisher: ");
        // Read input from user
        String publisher = reader.nextLine();

        // Ask for edition number
        System.out.println("Please enter edition number: ");
        // Read input from user
        int edition = reader.nextInt();

        Book book = new Book(title, author, publisher, edition);
        this.books.addBook(book);

        System.out.println("Book added.");
    }

    /**
     * Find and display a book based on title.
     */
    void findBookByName()
    {
        // Ask for book title
        System.out.println("Please enter book title: ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();

        Book book = books.findBookByTitle(title);

        if (book != null) {
            System.out.println("Book found: ");
            System.out.println("Title: " + book.getTitle() + ", "
                    + "Author: " + book.getAuthor() + ", "
                    + "Publisher: " + book.getPublisher() + ", "
                    + "Edition: " + book.getEdition());
        }
        else {
            System.out.println("Book not found.");
        }
    }
}