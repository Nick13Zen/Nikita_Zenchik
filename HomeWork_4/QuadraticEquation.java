/**
 * The class contain method for solving quadratic equation.
 * 
 * @author Nikuta Zenchik
 */
public class QuadraticEquation {
    // Constants
    static final int CONSTANT_FOUR = 4;
    static final int CONSTANT_TWO = 2;
    static final int CONSTANT_ZERO = 0;
    /**
     * The method solves the equation and prints results.
     * 
     * @param arg1 double value.
     * @param arg2 double value.
     * @param arg3 double value.
     */
    public static void solveDiscriminant(double arg1, double arg2, double arg3) {
        double D = Math.pow(arg2, CONSTANT_TWO)-CONSTANT_FOUR*arg1*arg3;
        if (!(Double.isInfinite(D))) {
            if (Main.checkZero(D)) {
                System.out.println(Message.ONE_ANSWER);
                System.out.println("x1,2="+Main.check(-(arg2 / CONSTANT_TWO * arg1)));
            } else { 
                   if (D<CONSTANT_ZERO) {
                       System.out.println(Message.LESS_THEN_ZERO);
                } else {
                       System.out.println(Message.TWO_ANSWER);
                       System.out.println("x1="+Main.check((-arg2+Math.sqrt(D))/(CONSTANT_TWO * arg1)));
                       System.out.println("x2="+Main.check((-arg2-Math.sqrt(D))/(CONSTANT_TWO * arg1)));
                }
            }
         } else {
               System.out.println(Message.BOUNDS_ERROR);
         }
    }
}

