/**
 * The class contain some <code>String</code> constants for user info, help
 * and some errors. It contain command line commands for program.
 *
 * @author Nikuta Zenchik
 */
public class Message {
    public static final String ABOUT = "The program solves quadratic equation and prints results.";

    public static final String ERROR_NOT_A_NUMBER = "Error. Input is " +
            "incorrect. Only numbers are allowed. Separator between integral " +
            "and fractional parts is \",\".";

    public static final String EMPTY = "Error. Line you entered is empty.";

    public static final String BOUNDS_ERROR = "Error. Exceed the bounds of " +
            "acceptable values";

    public static final String ONE_ANSWER = "Only one answer.";

    public static final String TWO_ANSWER = "Two answers.";

    public static final String LESS_THEN_ZERO = "Discriminant less then zero.";

    public static final String START = "Tipe in your line. Only numbers are allowed. "
            + "Program works only with three arguments.";

    public static final String BOUNDS_ERROR_INPUT = "Error. Exceed the bounds" +
            " of acceptable values. One of value or both is incorrect.";

    public static final String NAN_NUMBER = "Sorry, we can't calculate that " +
            "value.";
}