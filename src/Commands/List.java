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
public class List extends Command{

    int maxArgs = 0;
    public static int minArgs = 0;
    public static String name = "ls";

    public void call(String[] args, String[] flags) throws InvalidInputException {
        checkArgs(args, name, minArgs, maxArgs);
        System.out.print("Contents:");
        String[] children =FileSystem.getChildren();
        for(String s: children){
            System.out.print(s+ " ");
        }
        System.out.println();
    }
}
