import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * Main class which contained entry point.
 * It read input from command line as three numbers.
 * Finds out is it a triangular and with kind of it.
 * The program read only three number coming first. The following numbers are
 * ignored.
 *
 * @author Nikita Zenchik
 */
public class Main {
    /**
     * Print message and receive three numbers from console.
     */
    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println(Message.ABOUT);
            System.out.println();
            System.out.println(Message.START);
            Double arg1 = input.nextDouble();
            if (!(arg1.isNaN())) {
                Double arg2 = input.nextDouble();
                Double arg3 = input.nextDouble();
                Validator validator = new Validator();
                validator.checkInvalidData(arg1, arg2, arg3);
                if (validator.checkZero(arg1, arg2, arg3)) {
                    Solve solve = new Solve();
                    System.out.println(solve.solveTriangular(arg1, arg2, arg3));
                } else {
                    System.out.println(Message.AGR_ZERO);
                }
            }
        } catch (InvalidParameterException e) {
            e.getMessage();
        } catch (Exception exp) {
            System.out.println(Message.ERROR_NOT_A_NUMBER);
        }

    }
}
