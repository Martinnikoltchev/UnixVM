package Parser;

import Commands.Command;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:09 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class Parser {

    public static ParsedCommand parse(String line){
        String[] split_line  = line.split(" ");
        String command = split_line[0];
        ArrayList<String> flags = new ArrayList<String>();
        ArrayList<String> args = new ArrayList<String>();
        for(int i = 1; i < split_line.length; i++){
            String current = split_line[i];
            if(current.charAt(0)=='-')
                flags.add(parseFlag(current));
            else
                args.add(parseArg(current));
        }
        return new ParsedCommand(command, aListToStatic(flags) , aListToStatic(args));

    }

    public static String parseFlag(String flag){
        if(flag.charAt(1) == '-')
            return flag.substring(2);
        else
            return "" + flag.charAt(1);
    }

    public static String parseArg(String arg){
        return arg;
    }

    public static String[] aListToStatic(ArrayList<String> aList){
        String[] outputArr = new String[aList.size()];
        for(int i = 0; i < aList.size(); i++){
            outputArr[i] = aList.get(i);
        }
        return outputArr;
    }
}
