/**
 * 
 */
package LLD.DesignPattern.MementoDesignPattern;

/**
 * @author LENOVO
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextEditor originator = new TextEditor();
		TextEditorCaretaker  caretaker = new TextEditorCaretaker();
		
		originator.write("Hello World!");
		caretaker.save(originator);
		
		originator.write("I am new to this world!");
		caretaker.save(originator);
		
		originator.write("I want to play");
		
		caretaker.undo(originator);
		
		caretaker.undo(originator);
		
		caretaker.undo(originator);
	}

}
