/**
 * 
 */
package LLD.DesignPattern.MementoDesignPattern;

/**
 * @author LENOVO
 *
 */
// This is the Originator class
public class TextEditor {

	private String text;

	public void write(String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
		System.out.println("The current text is: " + this.text);
	}

	public TextEditorMemento save() {
		return new TextEditorMemento(text);
	}

	public void restore(TextEditorMemento memento) {
		text = memento.getText();
		System.out.println("Restore text is: " + this.text);
	}
}
