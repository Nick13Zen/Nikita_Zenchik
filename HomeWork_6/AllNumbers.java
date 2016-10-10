import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class contains method to identify if line has only numbers in it
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class AllNumbers extends Rule {
    /**
     * Method takes String line and finds if line contains only numbers.
     *
     * @param inputline string line.
     * @return True if line contains only numbers otherwise False.
     */
    @Override
    public boolean identifyRule(String inputline) {
        Pattern find = Pattern.compile("\\d+$");
        Matcher in = find.matcher(inputline);
        return in.matches();
    }

    /**
     * Method prints out line.
     */
    @Override
    public void printResult() {
        System.out.println(Message.ALL_NUMBERS);
    }
}
