/**
 * 
 */
package LLD.DesignPattern.CommandDesignPattern;

/**
 * @author LENOVO
 *
 */
public class LightOffCommand implements Command {

	private Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.light.turnOff();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.light.turnOn();
	}

}
