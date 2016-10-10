import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containts method to identify if line has numbers in it
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class NoNumbers extends Rule {
    /**
     * Method takes String line and finds if there is at lest one number.
     *
     * @param inputline string line.
     * @return True if line contains at least one number otherwise False.
     */
	@Override
    public boolean identifyRule(String inputline) {
        Pattern find = Pattern.compile("^\\D+$");
        Matcher in = find.matcher(inputline);
        return in.matches();
    }

    /**
     * Method prints out line.
     */
	@Override
    public void printResult () {
        System.out.println(Message.NO_NUMBERS);
    }
}
