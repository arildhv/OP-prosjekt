/**
 * Represents a book, with information on
 * title, author, publisher, and edition.
 *
 * @author Arild Valderhaug
 * @version v0.1 08.02.2019
 */
public class Book extends PrintMaterial
{
    // instance variables
    private String author;
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
        super(title, publisher);
        this.author = author;
        this.edition = edition;
    }

    /**
     * @return the author string of the book
     */
    public String getAuthor()
    {
        return this.author;
    }

    /**
     *  @return the edition number of the book
     */
    public int getEdition()
    {
        return this.edition;
    }

    /**
     * @return String containing all the details of the book
     */
    public String getDetails()
    {
        String returnString = super.getDetails();
        returnString += ", Author: " + this.author + ", Edition: " + this.edition;
        return returnString;
    }

    // The following are methods to be mutated by subclasses
    public int getPublishDate()
    {
        int i = 0;
        return i;
    }

    public String getSeriesName()
    {
        String n = new String();
        return n;
    }


}