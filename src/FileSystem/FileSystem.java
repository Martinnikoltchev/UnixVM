package FileSystem;

import Exceptions.InvalidInputException;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:53 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class FileSystem {

    private static final DirectoryNode root = new DirectoryNode("home", null,new ArrayList<FileElement>());
    private static DirectoryNode head = root;
    //cd
    public static void goTo(String destination) throws InvalidInputException{
        String[] dests = destination.split("//");
        for(int i = 0; i < dests.length; i++){
            changeLocal(dests[i]);
        }
    }
    //cd
    private static void changeLocal(String dest) throws InvalidInputException{
        if (dest.equals(".")){
            return;
        }
        else if(dest.equals("..")) {
            if(head!=root)
                head = head.parent;
        }
        else{
            FileElement elm = head.find(dest);
            if(elm == null){
                throw new InvalidInputException("The destination: " + dest+ " does not exist");
            }
            else if(elm instanceof DirectoryNode){
                 head = (DirectoryNode) elm;
            }
            else{
                throw new InvalidInputException("The destination: " + dest+ " is not a directory");
            }
        }


    }
    //touch
    public static void addFile(String name) throws InvalidInputException{
        if(!validName(name))
            throw new InvalidInputException("The name: "+ name +" is already taken");
        head.addFile(name);
    }
    //ls
    public static String[] getChildren(){
        String[] out = new String[head.children.size()];
        for(int i = 0; i < out.length; i++){
            out[i]=head.children.get(i).name;
        }
        return out;
    }

    //makedir
    public static void makeDir(String name) throws InvalidInputException{
        if(!validName(name))
            throw new InvalidInputException("The name: "+ name +" is already taken");
        head.addDir(name);
    }
    //pwd
    public static String getNameTraceback() {
        return head.traceName();
    }

    //touch, mkdir
    public static boolean validName(String name){
        for(FileElement element: head.children){
            if(element.name == name)
                return false;
        }
        return true;
    }
}
