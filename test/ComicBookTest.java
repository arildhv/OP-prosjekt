import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComicBookTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEditionsPerYear() {
        ComicBook comic = new ComicBook ("T", "P", 1, "G");
        int eds = comic.getEditionsPerYear();
        assertEquals(1, eds);
    }

    @Test
    public void getGenre() {
        ComicBook comic = new ComicBook ("T", "P", 1, "G");
        String gen = comic.getGenre();
        assertEquals("G", gen);
    }

    @Test
    public void getTitle() {
        ComicBook comic = new ComicBook ("T", "P", 1, "G");
        String title = comic.getTitle();
        assertEquals("T", title);
    }

    @Test
    public void getPublisher() {
        ComicBook comic = new ComicBook ("T", "P", 1, "G");
        String pub = comic.getPublisher();
        assertEquals("P", pub);
    }
}