/**
 * 
 */
package LLD.DesignPattern.CommandDesignPattern;

/**
 * @author LENOVO
 *
 */

// This is the Receiver
public class Light {
	public void turnOn() {
		System.out.println("Light Turn On");
	}
	
	public void turnOff() {
		System.out.println("Light Turn Off");
	}
}
