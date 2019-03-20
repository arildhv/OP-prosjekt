/**
 * Represents a book, with information on
 * title, author, publisher, and edition.
 *
 * @author Arild Valderhaug
 * @version v0.1 08.02.2019
 */
public class Book
{
    // instance variables
    private String title;
    private String author;
    private String publisher;
    private int edition;

    /**
     * Constructor for objects of class Book
     * @param title - The title of the book
     * @param author - The author of the book
     * @param publisher - The publisher of the book
     * @param edition - The edition of the book
     */
    public Book(String title, String author, String publisher, int edition)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
    }

    /**
     * @return the title string of the book
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * @return the author string of the book
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     * @return the publisher string of the book
     */
    public String getPublisher()
    {
        return this.publisher;
    }

    /**
     *  @return the edition number of the book
     */
    public int getEdition()
    {
        return this.edition;
    }
}