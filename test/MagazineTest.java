import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagazineTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEditionsPerYear() {
        Magazine mag = new Magazine ("T", "P", 1, "G");
        int eds = mag.getEditionsPerYear();
        assertEquals(1, eds);
    }

    @Test
    public void getGenre() {
        Magazine mag = new Magazine ("T", "P", 1, "G");
        String gen = mag.getGenre();
        assertEquals("G", gen);
    }

    @Test
    public void getTitle() {
        Magazine mag = new Magazine ("T", "P", 1, "G");
        String title = mag.getTitle();
        assertEquals("T", title);
    }

    @Test
    public void getPublisher() {
        Magazine mag = new Magazine ("T", "P", 1, "G");
        String pub = mag.getPublisher();
        assertEquals("P", pub);
    }
}