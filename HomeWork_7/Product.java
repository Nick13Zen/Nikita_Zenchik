import java.math.BigDecimal;

/**
 * Class that contains fields products name, type, count and price.
 * Constructor and methods to get values;
 *
 * @author Nikita Zenchik
 */
public class Product {
    /**
     * Name of product
     */
    private String name;
    /**
     * Type of product.
     */
    private String type;
    /**
     * Count of product.
     */
    private int count = 0;
    /**
     * Price of product.
     */
    private BigDecimal price = new BigDecimal(0);

    /**
     * Constructor.Creates objects of product.
     *
     * @param name  name of product
     * @param type  type of product
     * @param count count of product
     * @param price price of product
     */
    public Product(String type, String name, int count, double price) {
        this.name = name;
        this.type = type;
        this.count = count;
        this.price = BigDecimal.valueOf(price);
    }

    /**
     * Method to get type of product.
     *
     * @return products type.
     */
    public String getType() {
        return type;
    }

    /**
     * Method to get type of product.
     *
     * @return products type.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Method getCount returns the count of the products
     *
     * @return count of the product
     */
    public int getCount() {
        return count;
    }
}