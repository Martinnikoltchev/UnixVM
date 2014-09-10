import java.util.Scanner;

import Exceptions.InvalidInputException;
import Parser.Parser;

/**
 * Created with IntelliJ IDEA.
 * User: Martin
 * Date: 8/20/14
 * Time: 10:53 AM
 * To change this template use FileNode | Settings | FileNode Templates.
 */
public class ActiveUI {

    static String username = "User";
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        StateManager.init();
        while(true){
            try{
                System.out.print(username+ ": ");
                StateManager.call(scan.nextLine());
            }catch(InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
