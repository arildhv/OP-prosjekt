import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.junit.Assert.*;

public class InventoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getIterator() {
        Inventory inv = new Inventory();
        Book book1 = new Book("T", "A", "P", 1);
        Book book2 = new Book("T2", "A2", "P2", 2);
        inv.addItem(book1);
        inv.addItem(book2);
        Iterator<PrintMaterial> it = inv.getIterator();
        int i = 0;
        while(it.hasNext())
        {
            it.next();
            i++;
        }
        assertEquals(2, i);
        assertNotEquals(0, i);
    }

    @Test
    public void findItemByString() {
        Inventory inv = new Inventory();
        Book book1 = new Book("T", "A", "P", 1);
        Book book2 = new Book("T2", "A2", "P2", 2);
        inv.addItem(book1);
        inv.addItem(book2);
        PrintMaterial testMat = inv.findItemByString("T2", "");
        assertEquals("T2", testMat.getTitle());
        assertEquals("P2", testMat.getPublisher());
        testMat = inv.findItemByString("T2", "P");
        assertEquals(null, testMat);
    }
}