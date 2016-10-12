import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class calculates average price of created products of definite type
 *
 * @author Nikita Zenchik
 */
public class AverageType extends Command {

    /**
     * Method counts products of set by user type, their prices and outputs average price.
     *
     * @param type set by user type.
     * @param list list of products.
     */
    public void getAveragePriceOfOneType(String type, ArrayList<Product> list) {
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void checkCommand(String line, ArrayList<Product> products) {
    }
}