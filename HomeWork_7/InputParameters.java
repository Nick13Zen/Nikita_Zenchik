import java.util.*;

/**
 * Class contains two methods.
 * First to create new products.
 * Second to get list of products.
 *
 * @author Nikita Zenchik
 */
public class InputParameters {
    /**
     * List of created products
     */
    private ArrayList<Product> allproductslist = new ArrayList<>();

    public void newProduct() {
        String type, name;
        int count;
        double cost;
        Scanner input = new Scanner(System.in);
        String argument;
        do {
            System.out.println("Enter product's type");
            type = input.next();
            System.out.println("Enter product's name");
            name = input.next();
            System.out.println("Enter product's count");
            count = input.nextInt();
            System.out.println("Enter product's price");
            cost = input.nextDouble();
            System.out.println("Continue? (Enter 'yes' to repeat, any to continue)");
            argument = input.next();
            allproductslist.add(new Product(type, name, count, cost));
        } while (argument.equals("yes"));
    }

    /**
     * Method getList returns list of created products.
     *
     * @return list of products.
     */
    public ArrayList<Product> getList() {
        return allproductslist;
    }
}
