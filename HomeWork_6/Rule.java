/**
 * Abstract class to identify general behavior for all rules.
 *
 * @author Nikita Zenchik
 */
public abstract class Rule {

    /**
     * Method that checks if entered line satisfies the rule.
     *
     * @param inputLine
     * @return True if satisfies, False otherwise.
     */
    public abstract boolean identifyRule(String inputLine);

    /**
     * Method that prints result.
     */
    public abstract void printResult();
}
