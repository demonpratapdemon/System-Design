/**
 * 
 */
package LLD.DesignPattern.MediatorDesignPattern;

/**
 * @author LENOVO
 *
 */
public class ChatUser extends User {

	public ChatUser(ChatMediator mediator, String name) {
		super(mediator, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " sends:" + msg);
		this.mediator.sendMessage(this, msg);
	}

	@Override
	public void receive(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " receives:" + msg);
	}

}
