/**
 * Class contains method to identify if line has more than five words
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class MoreThanFiveWords extends Rule {
    /**
     * Method takes String line and finds if it has more then five words.
     *
     * @param inputline string line.
     * @return True if line contains more then five words otherwise False.
     */
    @Override
    public boolean identifyRule(String inputline) {
        int wordsallowed = 5;
        int words = inputline.split("\\w+").length;
        return words > wordsallowed;
    }

    /**
     * Method prints out line.
     */
    @Override
    public void printResult() {
        System.out.println(Message.MORE_THEN_FIVE);
    }
}
