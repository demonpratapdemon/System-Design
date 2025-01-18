/**
 * 
 */
package LLD.DesignPattern.MediatorDesignPattern;

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
		ChatMediator mediator = new ChatRoom();
		
		User user1 = new ChatUser(mediator, "Alice");
		User user2 = new ChatUser(mediator, "Bob");
		User user3 = new ChatUser(mediator, "Charlie");
		User user4 = new ChatUser(mediator, "Diana");
		
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		user1.send("Hello I am Alice");
		System.out.println();
		user3.send("Hi Alice");
	}

}
