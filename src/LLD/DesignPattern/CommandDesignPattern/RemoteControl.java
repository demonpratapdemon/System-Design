/**
 * 
 */
package LLD.DesignPattern.CommandDesignPattern;

import java.util.Stack;

/**
 * @author LENOVO
 *
 */

// Invoker
public class RemoteControl {
	
	private Stack<Command> commandHistory;
	
	public RemoteControl() {
		this.commandHistory = new Stack<Command>();
	}
	
	public void executeCommand(Command command) {
		command.execute();
		this.commandHistory.push(command);
	}
	
	public void undoLastCommand() {
		if (!this.commandHistory.empty()) {
			Command lastCommand = this.commandHistory.pop();
			lastCommand.undo();
		} else {
			System.out.println("No commands to UNDO");
		}
	}

}
