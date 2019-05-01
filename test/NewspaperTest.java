import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewspaperTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEditionsPerYear() {
        Newspaper news = new Newspaper ("T", "P", 1, "G");
        int eds = news.getEditionsPerYear();
        assertEquals(1, eds);
    }

    @Test
    public void getGenre() {
        Newspaper news = new Newspaper ("T", "P", 1, "G");
        String gen = news.getGenre();
        assertEquals("G", gen);
    }

    @Test
    public void getTitle() {
        Newspaper news = new Newspaper ("T", "P", 1, "G");
        String title = news.getTitle();
        assertEquals("T", title);
    }

    @Test
    public void getPublisher() {
        Newspaper news = new Newspaper ("T", "P", 1, "G");
        String pub = news.getPublisher();
        assertEquals("P", pub);
    }
}