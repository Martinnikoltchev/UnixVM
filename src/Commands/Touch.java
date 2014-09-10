package Commands;

import Exceptions.InvalidInputException;
import FileSystem.FileSystem;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Touch extends Command {

    public static int maxArgs = 1;
    public static int minArgs = 1;
    public static String name = "cd";

    public void call(String[] args, String[] flags) throws InvalidInputException {
        checkArgs(args, name, minArgs, maxArgs);
        FileSystem.addFile(args[0]);
    }
}
