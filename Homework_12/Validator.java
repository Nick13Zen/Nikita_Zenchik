import java.security.InvalidParameterException;

/**
 * Created by Nick on 04/11/16.
 */
public class Validator {
    /**
     * The method check if number is zero.
     *
     * @param arg1 double value.
     * @param arg2 double value.
     * @param arg3 double value.
     * @return False if zero==0.
     */
    public boolean checkZero(double arg1, double arg2, double arg3) {
        return (!((new Double(1.0 / arg1).isInfinite()) || (new Double(1.0 / arg2).isInfinite())
                || (new Double(1.0 / arg3).isInfinite())));
    }

    /**
     * Method to identify if input data is invalid.
     * Throws exception.
     *
     * @param arg1 double value.
     * @param arg2 double value.
     * @param arg3 double value.
     */
    public void checkInvalidData(double arg1, double arg2, double arg3) throws Exception {
        if ((Double.isNaN(arg1))
                || (Double.isNaN(arg2))
                || (Double.isNaN(arg3))) {
            throw new InvalidParameterException(Message.NAN_NUMBER);
        }
        if ((arg1 == Double.MIN_VALUE)
                || (arg2 == Double.MIN_VALUE)
                || (arg3 == Double.MIN_VALUE)) {
            throw new InvalidParameterException(Message.NAN_NUMBER);
        }
        if ((arg1 == Double.MAX_VALUE)
                || (arg2 == Double.MAX_VALUE)
                || (arg3 == Double.MAX_VALUE)) {
            throw new InvalidParameterException(Message.NAN_NUMBER);
        }
        if ((Double.isInfinite(arg1))
                || (Double.isInfinite(arg2))
                || (Double.isInfinite(arg3))) {
            throw new InvalidParameterException(Message.NAN_NUMBER);
        }
    }
}
