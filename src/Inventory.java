import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for creating an array that stores objects of class Book.
 * Any inquiries into the array are made through this class.
 *
 * @author Arild Valderhaug
 * @version 0.9
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
     */
    public Iterator<PrintMaterial> getIterator()
    {
        return this.printMatList.iterator();
    }

    /**
     * Search the collection for a specific material given the title, and publisher if known.
     * If no publisher is entered, only search by title.
     * Return the material if found.
     */
    public PrintMaterial findItemByString(String title, String publisher)
    {
        PrintMaterial printMat = null;
        boolean found = false;

        int i = 0;
        while ((i < this.printMatList.size()) && !found)
        {
            PrintMaterial m = printMatList.get(i);
            if(publisher.equals("")) {
                if (m.getTitle().equals(title)) {
                    printMat = m;
                    found = true;
                }
            }
            else{
                if((m.getTitle().equals(title)) && m.getPublisher().equals(publisher)){
                    printMat = m;
                    found = true;
                }
            }
            i++;
        }
        return printMat;
    }

    /**
     * Search the collection for a material by a given publisher
     * Will print print details of every item found from that publisher.
     */
    public void listByPublisher(String publisher)
    {
        boolean found = false;

        int i = 0;
        while (i < this.printMatList.size())
        {
            PrintMaterial m = printMatList.get(i);
            if (m.getPublisher().equals(publisher)) {
                System.out.println(m.getDetails());
                found = true;
            }
            i++;
        }
        if (!found){
            System.out.println("No items found.");
        }
    }
}