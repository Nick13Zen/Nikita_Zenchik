import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containts method to identify if line has numbers in it
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
abstract class NoNumbers {
    /**
     * Method takes String line and finds if there is at lest one number.
     *
     * @param inputline string line.
     * @return True if line contains no numbers.
     * @return False if line contains at least one number.
     */
    public static boolean findNumber(String inputline) {
        Pattern find = Pattern.compile("^\\D+$");
        Matcher in = find.matcher(inputline);
        if (in.matches()) {
            NoNumbers.printResult();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method prints out line.
     */
    public static void printResult() {
        System.out.println(Message.NO_NUMBERS);
    }

}
