import java.math.BigDecimal;
import java.util.*;

/**
 * Class calculates average price of created products.
 *
 * @author Nikita Zenchik
 */
public class AveragePrice extends Command {
    /**
     * Method outputs average price of all products.
     *
     * @param list list of products.
     */
    public void averagePriceOfAllTypes(ArrayList<Product> list) {
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void checkCommand(String line, ArrayList<Product> products) {
        if (line.equals("average price")) {
            averagePriceOfAllTypes(products);
        }
    }
}
