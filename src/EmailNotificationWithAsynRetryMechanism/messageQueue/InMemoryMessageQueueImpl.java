package EmailNotificationWithAsynRetryMechanism.messageQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;

public class InMemoryMessageQueueImpl implements IMessageQueue {

	private final BlockingQueue<EmailMessage> queue = new LinkedBlockingDeque<EmailMessage>();

	@Override
	public void enqueue(EmailMessage message) {
		// TODO Auto-generated method stub
		queue.add(message);
	}

	@Override
	public EmailMessage deque() {
		// TODO Auto-generated method stub
		try {
			return queue.take();
		} catch (Exception e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
			return null;
		}
	}

}
