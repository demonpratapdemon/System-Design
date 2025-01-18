/**
 * 
 */
package LLD.DesignPattern.MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LENOVO
 *
 */
public class ChatRoom implements ChatMediator {

	private List<User> users;

	public ChatRoom() {
		this.users = new ArrayList<User>();
	}

	@Override
	public void sendMessage(User user, String msg) {
		// TODO Auto-generated method stub
		for (User u : this.users) {
//			Don't send message to the person sending the message
			if (u != user)
				u.receive(msg);
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.users.add(user);
	}

}
