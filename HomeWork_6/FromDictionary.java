/**
 * Class containts method to identify if line contains word from dictionary
 * and method that prints result.
 *
 * @author Nikita Zenchik
 */
public class FromDictionary extends Rule {
    //constant
    static final String dictionary = "start";

    /**
     * Method takes String line and finds if there is at lest one number.
     *
     * @param inputline string line.
     * @return True if line contains word from dictionary otherwise False.
     */
    @Override
    public boolean identifyRule(String inputline) {
        return (inputline.contains(dictionary));
    }

    /**
     * Method prints out line.
     */
    @Override
    public void printResult() {
        System.out.println(Message.FROM_DICTIONARY);
    }
}
