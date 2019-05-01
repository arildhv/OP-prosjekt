import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for creating an array that stores objects of class Book.
 * Any inquiries into the array are made through this class.
 *
 * @author Arild Valderhaug
 * @version 0.2
 */
public class BookCollection
{
    // An ArrayList for storing books in the collection.
    private ArrayList<Book> bookList;

    /**
     * Constructor for objects of
     */
    public BookCollection()
    {
        bookList = new ArrayList<>();
    }

    /**
     * Add a book to the collection
     *
     * @param book The book to be added to the collection
     */
    public void addBook(Book book)
    {
        this.bookList.add(book);
    }

    /**
     * List all books in the collection, using the bookList iterator.
     */
    public Iterator<Book> getIterator()
    {
        return bookList.iterator();
    }

    /**
     * Search the collection for a book given the title.
     * Return the book if found.
     */
    public Book findBookByTitle(String title)
    {
        Book book = null;
        boolean found = false;

        int i = 0;
        while ((i < this.bookList.size()) && !found)
        {
            Book b = bookList.get(i);
            if (b.getTitle().equals(title))
            {
                book = b;
                found = true;
            }
            i++;
        }

        return book;
    }

    /**
     * Search the collection for a book given the author.
     * Will currently return first book found by author.
     * List all books by author to be added in future version.
     */
    public Book findBookByAuthor(String author)
    {
        Book book = null;
        boolean found = false;

        int i = 0;
        while ((i < this.bookList.size()) && !found)
        {
            Book b = bookList.get(i);
            if (b.getAuthor().equals(author))
            {
                book = b;
                found = true;
            }
            i++;
        }

        return book;
    }

    /**
     * Remove a book from the collection
     */
    public void removeBook(int index)
    {
        bookList.remove(index);
    }

    /**
     * Return the array size of the bookCollection.
     * This method is primarily used for test purposes.
     */
    public int getArraySize()
    {
        return this.bookList.size();
    }
}