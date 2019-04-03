/**
 * Represents all types of periodicals, with information on
 * title, publisher, number of editions per year, and genre
 */
public class Periodical extends PrintMaterial  {

    private int editionsPerYear;
    private String genre;

    public Periodical (String title, String publisher, int editionsPerYear, String genre)
    {
        super(title, publisher);
        this.editionsPerYear = editionsPerYear;
        this.genre = genre;
    }

    /**
     * @return   the number of editions per year
     */
    public int getEditionsPerYear()
    {
        return this.editionsPerYear;
    }

    /**
     * @return The genre of this periodical
     */
    public String getGenre()
    {
        return this.genre;
    }

    /**
     * @return String containing all the details of the periodical
     */
    public String getDetails()
    {
        String returnString = super.getDetails();
        returnString += ", Genre: " + this.genre + ", Editions per year: " + this.editionsPerYear;
        return returnString;
    }
}
