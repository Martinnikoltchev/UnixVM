import Commands.*;
import Parser.*;
import Exceptions.InvalidInputException;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:06 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class StateManager {
    public static HashMap<String, Command> commandMap= new HashMap<String,Command>();
    public static State vmState = new State();

    public static void call (String line) throws InvalidInputException{
        ParsedCommand pc = Parser.parse(line);
        Command c = commandMap.get(pc.command);
        if(c == null){
            throw new InvalidInputException("The command '"+pc.command+ "' is not supported");
        }
        c.call(pc.args, pc.flags);

    }

    public static void init(){
        commandMap.put("cd", new ChangeDirectory());
        commandMap.put("touch", new Touch());
        commandMap.put("ls", new List());
        commandMap.put("mkdir", new MakeDirectory());
        commandMap.put("pwd", new PrintWorkingDirectory());
    }
}
