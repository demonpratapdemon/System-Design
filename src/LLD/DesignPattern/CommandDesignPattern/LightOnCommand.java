/**
 * 
 */
package LLD.DesignPattern.CommandDesignPattern;

/**
 * @author LENOVO
 *
 */
public class LightOnCommand implements Command {

	private Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.light.turnOn();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.light.turnOff();
	}

}
