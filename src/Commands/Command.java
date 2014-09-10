package Commands;

import Exceptions.InvalidInputException;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:09 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public abstract class Command {
    public int maxArgs;
    public int minArgs;
    public String name;


    public abstract void call(String[] args, String[] flags) throws InvalidInputException;

    public void checkArgs(String[] args, String name, int minArgs, int maxArgs) throws InvalidInputException{
        if(args.length>maxArgs){
            throw new InvalidInputException("To many arguments passed into "+ name);
        }
        if(args.length<minArgs){
            throw new InvalidInputException("To few arguments passed into "+ name);
        }
    }
}
