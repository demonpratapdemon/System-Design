/**
 * 
 */
package LLD.DesignPattern.CommandDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 *
 */

// This is the Client
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Light lightObj = new Light();
//		Commands
		Command lightOn = new LightOnCommand(lightObj);
		Command lightOff = new LightOffCommand(lightObj);

//		Invoker
		RemoteControl remote = new RemoteControl();
		
//		Execute Commands
		System.out.println("Executing commands:");
		remote.executeCommand(lightOn);
		remote.executeCommand(lightOff);
		
//		Undo the last command
		System.out.println("\nUndoing the last command");
		remote.undoLastCommand();
		
//		Undo another command
        System.out.println("\nUndoing another command:");
        remote.undoLastCommand(); // Output: The light is OFF.

////      Attempt to undo with no commands left
//        System.out.println("\nUndoing with no commands left:");
//        remote.undoLastCommand(); // Output: No commands to undo.
        
//      Redo last undone command
        System.out.println("\nRedoing another command:");
        remote.redoLastCommand(); // Output: The light is OFF.

//      Attempt to redo with no commands left
        System.out.println("\nRedoing with no commands left:");
        remote.redoLastCommand(); // Output: No commands to redo.
		
        List<Integer>  list = new ArrayList<Integer>();
        list.iterator();
	}

}
