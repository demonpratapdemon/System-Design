package EmailNotificationWithAsynRetryMechanism.messageQueue;

import EmailNotificationWithAsynRetryMechanism.entities.EmailMessage;

public interface IMessageQueue {
	void enqueue(EmailMessage message);

	EmailMessage deque();
}
