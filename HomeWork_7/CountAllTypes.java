import java.util.ArrayList;

/**
 * Class CountTypes counts types of created products.
 *
 * @author Nikita Zenchik
 */
public class CountAllTypes extends Command {

    /**
     * Method calculate the count of types.
     *
     * @param products list of products.
     */
    public static void getCountTypes(ArrayList<Product> products) {
    }

    /**
     * Overrides method from superclass Command, verifies input command and perform command
     *
     * @param line     user's command
     * @param products list of created products
     */
    @Override
    public void checkCommand(String line, ArrayList<Product> products) {
        if (line.equals("count types")) {
            getCountTypes(products);
        }
    }
}