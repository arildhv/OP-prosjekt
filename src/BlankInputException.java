/**
 * Checked exception to be thrown when the user inputs an empty string.
 *
 * @author Arild Valderhaug
 * @version 1.0
 */

public class BlankInputException extends Exception {

    public BlankInputException(String message){
        super(message);
    }
}
