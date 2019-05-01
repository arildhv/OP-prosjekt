import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for creating an array that stores objects of class Book.
 * Any inquiries into the array are made through this class.
 *
 * @author Arild Valderhaug
 * @version 1.0
 */
public class Inventory
{
    // An ArrayList for storing books in the collection.
    private ArrayList<PrintMaterial> printMatList;

    /**
     * Constructor for objects of class BookCollection
     */
    public Inventory()
    {
        this.printMatList = new ArrayList<>();
    }

    /**
     * Add an item to the collection
     *
     * @param printMaterial The printed material to be added to the collection
     */
    public void addItem(PrintMaterial printMaterial)
    {
        this.printMatList.add(printMaterial);
    }

    /**
     * Accessor method for the iterator
     * @return the iterator for this inventory
     */
    public Iterator<PrintMaterial> getIterator()
    {
        return this.printMatList.iterator();
    }

    /**
     * Search the collection for a specific material given the title and publisher.
     * @param title The title, entered by the user, to search for
     * @param publisher The publisher, entered by the user, to search for
     * @return returns the PrintMaterial object which matches the search criteria. Otherwise returns a null object.
     */
    public PrintMaterial findItemByString(String title, String publisher)
    {

        PrintMaterial printMat = null;
        boolean found = false;

        int i = 0;
        while ((i < this.printMatList.size()) && !found)
        {
            PrintMaterial m = printMatList.get(i);

            if((m.getTitle().equals(title)) && m.getPublisher().equals(publisher)){
                    printMat = m;
                    found = true;
            }

            i++;
        }
        return printMat;
    }
}