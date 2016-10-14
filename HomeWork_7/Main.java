import java.util.*;

/**
 * Class Main has entry point to the program.
 *
 * @author Nikita Zenchik
 */
public class Main {

    /**
     * Method main calls class Initializer to set products, then it
     * creates list of commands, send list of products and list of commands to
     * class, that performs commands
     */
    public static void main(String[] args) {
        InputParameters start = new InputParameters();

        start.newProduct();

        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new CountAllProducts());
        commands.add(new CountAllTypes());
        commands.add(new AveragePrice());
        commands.add(new AverageType());

       new CommandRunner(start.getList(), commands);
    }
}