import java.security.InvalidParameterException;

/**
 * Created by Nick on 04/11/16.
 */
public class Solve {
    /**
     * The method finds of witch kind is triangular and does it exist.
     *
     * @param arg1 double value.
     * @param arg2 double value.
     * @param arg3 double value.
     */
    public String solveTriangular(double arg1, double arg2, double arg3) throws Exception {
        if (((arg1 + arg2) > arg3) && ((arg1 + arg3) > arg2) && ((arg3 + arg2) > arg1)) {
            if ((arg1 == arg2) && (arg2 == arg3) && (arg1 == arg3)) {
                return Message.EQUILATERAL;
            } else {
                if ((arg1 == arg2) || (arg2 == arg3) || (arg1 == arg3)) {
                    return Message.ISOSCELES;
                } else {
                    return Message.SIMPLE;
                }
            }
        } else {
            return Message.NOT_A_TRIANGULAR;
        }
    }
}
