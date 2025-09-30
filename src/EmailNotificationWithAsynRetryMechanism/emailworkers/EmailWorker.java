package EmailNotificationWithAsynRetryMechanism.emailworkers;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;
import EmailNotificationWithAsynRetryMechanism.messageQueue.IMessageQueue;

public class EmailWorker implements Runnable {
	private IMessageQueue queue;
	private EmailSender sender;
	private RetryScheduler retyrScheduler;

	public EmailWorker(IMessageQueue queue, EmailSender sender, RetryScheduler retyrScheduler) {
		this.queue = queue;
		this.sender = sender;
		this.retyrScheduler = retyrScheduler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			EmailMessage msg = queue.deque();
			if (msg != null) {
				boolean success = sender.send(msg);
				if (!success) {
					System.out.println("Retrying sending email");
					retyrScheduler.scheduleRetry(msg);
				}
			}
		}
	}

}
