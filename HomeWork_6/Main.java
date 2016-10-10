import java.util.Scanner;

/**
 * Main class which contained entry point.
 * It reads input from command line and transmits it to other classes.
 *
 * @author Nikita Zenchik
 */
public class Main {
    /**
     * Method that reads input from command line and transmits it to other classes.
     */
    public static void main(String[] args) {
        System.out.println(Message.ABOUT);
        System.out.println(Message.START);
        Scanner input = new Scanner(System.in);
        String inputLine = input.nextLine();
        if (inputLine != null && !inputLine.isEmpty()) {
            Rule[] rulesList = { new AllNumbers()
                    , new NoNumbers()
                    , new MoreThanFiveWords()
                    , new FromDictionary() };
            boolean noHits = true;
            for (Rule rule : rulesList) {
                if (rule.identifyRule(inputLine)) {
                    rule.printResult();
                    noHits = false;
                }
            }
            if (noHits) {
                System.out.println(Message.NO_HITS);
            }
        } else {
            System.out.println(Message.EMPTY_LINE);
        }
    }

}
