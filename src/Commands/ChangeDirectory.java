package Commands;

import Exceptions.InvalidInputException;
import FileSystem.FileSystem;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:34 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class ChangeDirectory extends Command{
    public static int maxArgs = 1;
    public static int minArgs = 1;
    public static String name = "cd";

    public void call(String[] args, String[] flags)throws InvalidInputException{
        checkArgs(args, name, minArgs, maxArgs);
        FileSystem.goTo(args[0]);
    }
}
