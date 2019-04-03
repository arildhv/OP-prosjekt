/**
 * Represents a book series
 * TODO Refactor to an array holding the books which make up a specific series
 */
public class BookSeries extends Book {

    private String seriesName;
    private int publishDate;

    public BookSeries (String title, String publisher, String author, int edition, String seriesName, int published)
    {
        super(title, author, publisher, edition);
        this.seriesName = seriesName;
        this.publishDate = published;
    }

    /**
     * @return the name of the book series
     */
    public String getSeriesName()
    {
        return this.seriesName;
    }

    /**
     * @return the publish date
     */
    public int getPublishDate()
    {
        return this.publishDate;
    }

    /**
     * @return String containing all the details of the book series
     */
    public String getDetails()
    {
        String returnString = super.getDetails();
        returnString += ", Series: " + this.seriesName + ", Date published: " + this.publishDate;
        return returnString;
    }
}
