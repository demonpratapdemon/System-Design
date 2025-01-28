/**
 * 
 */
package LLD.DesignPattern.MementoDesignPattern;

import java.util.Stack;

/**
 * @author LENOVO
 *
 */
// This is the Caretaker class that manages the memento for undo functionality
public class TextEditorCaretaker {

	private Stack<TextEditorMemento> history = new Stack<TextEditorMemento>();
	
	public void save(TextEditor editor) {
		this.history.push(editor.save());
		System.out.println("State saved");
	}
	
	public void undo(TextEditor editor) {
		if (!this.history.isEmpty()) {
			TextEditorMemento prevMemento = this.history.pop();
			editor.restore(prevMemento);
		} else {
			System.out.println("No states to undo");
		}
	}
}
