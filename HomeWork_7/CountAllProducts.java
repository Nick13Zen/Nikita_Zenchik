import java.util.ArrayList;

/**
 * Class CountAll counts all products that are set by user.
 *
 * @author Nikita Zenchik
 */
public class CountAllProducts extends Command {

    /**
     * Method count products and outputs it to user.
     *
     * @param list list of created products
     */
    public void countAllProducts(ArrayList<Product> list) {
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void checkCommand(String line, ArrayList<Product> products) {
        if (line.equals("count all")) {
            countAllProducts(products);
        }
    }
}