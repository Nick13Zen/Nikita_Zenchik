/**
 * Class containts method to identify if line contains word from dictionary
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class FromDictionary {
    /**
     * Method takes String line and finds if there is at lest one number.
     *
     * @param inputline string line.
     * @return True if line doesn't contain word from dictionary.
     * @return False if line contains word from dictionary.
     */
    public static boolean findMatche(String inputline) {
        String dictionary = "start";
        if (inputline.contains(dictionary)) {
            FromDictionary.printResult();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method prints out line.
     */
    public static void printResult() {
        System.out.println(Message.FROM_DICTIONARY);
    }
}
