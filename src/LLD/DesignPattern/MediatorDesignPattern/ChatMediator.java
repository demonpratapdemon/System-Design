/**
 * 
 */
package LLD.DesignPattern.MediatorDesignPattern;

/**
 * @author LENOVO
 *
 */
public interface ChatMediator {

	void sendMessage(User user, String msg);
	void addUser(User user);
}
