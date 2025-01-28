/**
 * 
 */
package LLD.DesignPattern.MementoDesignPattern;

/**
 * @author LENOVO
 *
 */
// This is the Memento class responsible to hold the state of the object
public class TextEditorMemento {
	
	private final String text;

	public TextEditorMemento(String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}

}
