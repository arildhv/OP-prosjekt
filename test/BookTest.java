import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test that getAuthor method returns correct values.
     */
    @Test
    public void getAuthorTest()
    {
        Book book = new  Book("Title", "Author", "Publisher", 1);
        String author = book.getAuthor();
        assertEquals("Author", author);
    }

    /**
     * Test that getEdition method returns correct values.
     */
    @Test
    public void getEditionTest()
    {
        Book book = new  Book("Title", "Author", "Publisher", 1);
        String pub = book.getPublisher();
        assertEquals("Publisher", pub);
    }
}