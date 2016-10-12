import java.util.ArrayList;

/**
 * Base class Command has only one method performCommand
 *
 * @author Nikita Zenchik
 */
public abstract class Command {

    /**
     * Method performCommand will be overridden
     */
    public abstract void checkCommand(String line, ArrayList<Product> list);
}