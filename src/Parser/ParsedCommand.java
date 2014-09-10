package Parser;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:45 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class ParsedCommand {
    public String command;
    public String[] args;
    public String[] flags;
    public ParsedCommand(String c, String[] f, String[] a){
        command = c;
        args = a;
        flags = f;
    }
    public String toString(){
        String out = "Command: "+command+ ", Args: ";
        for(String a: args){
            out+= a+", ";
        }
        out+="Flags: ";
        for(String f: flags){
            out+= f+", ";
        }
        return out;
    }
}
