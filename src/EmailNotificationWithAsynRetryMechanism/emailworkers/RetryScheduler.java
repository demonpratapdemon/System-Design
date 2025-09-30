package EmailNotificationWithAsynRetryMechanism.emailworkers;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;
import EmailNotificationWithAsynRetryMechanism.enums.MessageStatus;
import EmailNotificationWithAsynRetryMechanism.messageQueue.IMessageQueue;

public class RetryScheduler {

	private IMessageQueue queue;
	private int maxRetries;
	private long delayInMS;

	public RetryScheduler(IMessageQueue queue, int maxRetries, long delayInMS) {
		this.queue = queue;
		this.maxRetries = maxRetries;
		this.delayInMS = delayInMS;
	}

	public void scheduleRetry(EmailMessage msg) {
		// TODO Auto-generated method stub
		if (msg.getRetryCount() < maxRetries) {
			msg.setRetryCount(msg.getRetryCount() + 1);
			new Thread(() -> {
				try {
					Thread.sleep(delayInMS);
					queue.enqueue(msg);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}).start();
		} else {
			msg.setStatus(MessageStatus.FAILED);
			System.out.println("Email permanently failed : " + msg.getRequest().getTo());
		}
	}

}
