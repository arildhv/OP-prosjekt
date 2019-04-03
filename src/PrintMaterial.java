/**
 * A superclass to be used in creating various printed materials
 * It contains title and publisher, which is universal for all printed materials.
 * Some methods are intended to be mutated by subclasses. These methods return
 * errorString or errorInt if called from this class.
 */

public class PrintMaterial {
    private String title;
    private String publisher;
    private String errorString = "n/a";
    private int errorInt = 0;

    /**
     * Constructor for the abstract class Literature
     *
     * @param title - the title of the current item
     */
    public PrintMaterial(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    /**
     * @return The value stored in the title variable
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return The value stored in publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    // Define all abstract classes that will have an override in subclasses.

    public String getAuthor() {
        return errorString;
    }

    public int getEdition() {
        return errorInt;
    }


    public String getSeriesName() {
        return errorString;
    }

    public int getPublishDate() {
        return errorInt;
    }

    public int getEditionsPerYear() {
        return errorInt;
    }

    public String getGenre() {
        return errorString;
    }

    public String getDetails() {
        String returnString = new String();
        returnString = "Title: " + this.title + ", Publisher: " + this.publisher;
        return returnString;
    }
}
