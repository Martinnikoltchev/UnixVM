package Commands;

import Exceptions.InvalidInputException;
import FileSystem.FileSystem;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class MakeDirectory extends Command {
     int maxArgs = 1;
    public static int minArgs = 1;
    public static String name = "mkdir";

    public void call(String[] args, String[] flags) throws InvalidInputException {
        checkArgs(args, name, minArgs, maxArgs);
        FileSystem.makeDir(args[0]);
    }
}
