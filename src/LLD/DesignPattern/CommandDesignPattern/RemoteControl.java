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
	private Stack<Command> redoStack;
	
	public RemoteControl() {
		this.commandHistory = new Stack<Command>();
		this.redoStack = new Stack<Command>();
	}
	
	public void executeCommand(Command command) {
		command.execute();
		this.commandHistory.push(command);
		this.redoStack.clear();
	}
	
	public void undoLastCommand() {
		if (!this.commandHistory.empty()) {
			Command lastCommand = this.commandHistory.pop();
			lastCommand.undo();
			this.redoStack.push(lastCommand);
		} else {
			System.out.println("No commands to UNDO");
		}
	}
	
	public void redoLastCommand() {
        if (!redoStack.isEmpty()) {
            Command lastCommand = redoStack.pop();
            lastCommand.execute();
            this.commandHistory.push(lastCommand);
        } else {
            System.out.println("No commands to redo.");
        }
    }

}
