/**
 * Class contains method to identify if line has five word
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class FiveWords {
    /**
     * Method takes String line and finds if it has more then five words.
     *
     * @param inputline string line.
     * @return True if line contains five or less words .
     * @return False if line contains more then five words.
     */
    public static boolean howManyWords(String inputline) {
        int words = inputline.split("\\w+").length;
        if (words > 5) {
            FiveWords.printResult();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method prints out line.
     */
    public static void printResult() {
        System.out.println(Message.MORE_THEN_FIVE);
    }
}
