import java.util.Scanner;

/**
 * Main class which contained entry point.
 * It reads input from command line and transmits it to other classes.
 *
 * @author Nikita Zenchik
 */
public class Main {

    public static void main(String[] args) {
        
        boolean allnumbers;
        boolean fivewords;
        boolean nonumbers;
        boolean fromdictionary;
        
        System.out.println(Message.ABOUT);
        System.out.println(Message.START);
        Scanner input = new Scanner(System.in);
        String inputline = input.nextLine();
        if (!inputline.isEmpty()) {
           allnumbers = AllNumbers.findAllNumbers(inputline);
            nonumbers = NoNumbers.findNumber(inputline);
            fivewords = FiveWords.howManyWords(inputline);
            fromdictionary = FromDictionary.findMatche(inputline);
            if(allnumbers && fivewords && nonumbers && fromdictionary){
                System.out.println(Message.NO_HITS);
            }
        } else {
           System.out.println(Message.EMPTY_LINE);
        }
    }

}
