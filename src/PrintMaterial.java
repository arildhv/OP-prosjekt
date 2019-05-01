/**
 * A superclass to be used in creating various printed materials
 * It contains title and publisher, which is universal for all printed materials.
 *
 * @author Arild Valderhaug
 * @version 1.0
 */

public abstract class PrintMaterial
{
    private String title;
    private String publisher;

    /**
     * Constructor for the abstract class Literature
     */
    public PrintMaterial(String title, String publisher)
    {
        this.title = title;
        this.publisher = publisher;
    }

    /**
     * @return The value stored in the title variable
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * @return The value stored in the publisher variable
     */
    public String getPublisher()
    {
        return this.publisher;
    }
}
