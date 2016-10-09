import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containts method to identify if line has only numbers in it
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class AllNumbers {
    /**
     * Method takes String line and finds if line contains only numbers.
     *
     * @param inputline string line.
     * @return True if line contains at least one symbol.
     * @return False if line contains only numbers.
     */
    public static boolean findAllNumbers(String inputline) {
        Pattern find = Pattern.compile("\\d+$");
        Matcher in = find.matcher(inputline);
        if (in.matches()) {
            AllNumbers.printResult();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method prints out line.
     */
    public static void printResult() {
        System.out.println(Message.ALL_NUMBERS);
    }
}
