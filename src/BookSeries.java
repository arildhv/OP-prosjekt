import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a book series.
 * The title of the series is stored in a string.
 * All books that make up the series are individual book objects that are added to the series array.
 */
public class BookSeries extends PrintMaterial {

    private ArrayList<Book> bookSeries;

    public BookSeries (String title, String publisher)
        {
        super(title, publisher);
        this.bookSeries = new ArrayList<>();
        }

    /**
     * Getter method for the title string of the book series
     * @return the name of the book series
     */
    public void addItem(Book book)
    {
        this.bookSeries.add(book);
    }

    /**
     * Accessor method for the iterator of this book series array.
     * @return the iterator for this book series array
     */
    public Iterator<Book> getBookSeriesIterator()
    {
        return this.bookSeries.iterator();
    }


}
