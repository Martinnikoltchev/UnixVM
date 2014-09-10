package FileSystem;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 11:54 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class DirectoryNode extends FileElement{

    DirectoryNode parent;
    ArrayList<FileElement> children;

    public DirectoryNode(String n, DirectoryNode p, ArrayList<FileElement> c){
        name = n;
        parent = p;
        children = c;
    }

    public FileElement find(String s){
        for(FileElement e: children){
            if(e.name.equals(s)){
                return e;
            }
        }
        return null;
    }

    public void addDir(String s){
        children.add(new DirectoryNode(s, this, new ArrayList<FileElement>()));
    }

    public void addFile(String s){
        children.add(new FileNode(s));
    }

    public void remove(String s){

    }

    public String traceName() {
        if(parent==null)
            return name;
        return parent.traceName()+ "/"+name;
    }
}
