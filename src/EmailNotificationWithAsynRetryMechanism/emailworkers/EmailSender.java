package EmailNotificationWithAsynRetryMechanism.emailworkers;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;

public class EmailSender {

	public boolean send(EmailMessage msg) {
		// TODO Auto-generated method stub
		System.out.println("Sending email to : " + msg.getRequest().getTo());
		return Math.random() > 0.3;
	}

}
