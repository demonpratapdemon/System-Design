package EmailNotificationWithAsynRetryMechanism.service;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;
import EmailNotificationWithAsynRetryMechanism.entities.EmailRequest;
import EmailNotificationWithAsynRetryMechanism.enums.MessageStatus;
import EmailNotificationWithAsynRetryMechanism.messageQueue.IMessageQueue;

public class NotificationServiceImpl implements INotificationService {
	private IMessageQueue queue;

	public NotificationServiceImpl(IMessageQueue queue) {
		this.queue = queue;
	}

	@Override
	public void sendEmail(EmailRequest request) {
		// TODO Auto-generated method stub
		EmailMessage message = new EmailMessage(request, 0, MessageStatus.PENDING);
		queue.enqueue(message);
	}

}
