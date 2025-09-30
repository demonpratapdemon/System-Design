package EmailNotificationWithAsynRetryMechanism;

import EmailNotificationWithAsynRetryMechanism.emailworkers.EmailSender;
import EmailNotificationWithAsynRetryMechanism.emailworkers.EmailWorker;
import EmailNotificationWithAsynRetryMechanism.emailworkers.RetryScheduler;
import EmailNotificationWithAsynRetryMechanism.entities.EmailRequest;
import EmailNotificationWithAsynRetryMechanism.messageQueue.IMessageQueue;
import EmailNotificationWithAsynRetryMechanism.messageQueue.InMemoryMessageQueueImpl;
import EmailNotificationWithAsynRetryMechanism.service.INotificationService;
import EmailNotificationWithAsynRetryMechanism.service.NotificationServiceImpl;

public class SendEmailClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMessageQueue queue = new InMemoryMessageQueueImpl();
		EmailSender sender = new EmailSender();
		RetryScheduler scheduler = new RetryScheduler(queue, 3, 2000);
		EmailWorker worker = new EmailWorker(queue, sender, scheduler);
		
		new Thread(worker).start();
		
		INotificationService service = new NotificationServiceImpl(queue);
		service.sendEmail(new EmailRequest("pratapc@gmail.com", "arghya@gmail.com", "Urgent", "Check Email Body"));
	}

}
	