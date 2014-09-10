package Commands;

import Exceptions.InvalidInputException;
import FileSystem.FileSystem;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/22/14
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrintWorkingDirectory extends Command{

    int maxArgs = 0;
    public static int minArgs = 0;
    public static String name = "pwd";

    public void call(String[] args, String[] flags) throws InvalidInputException {
        checkArgs(args, name, minArgs, maxArgs);
        System.out.println(FileSystem.getNameTraceback());
    }
}
