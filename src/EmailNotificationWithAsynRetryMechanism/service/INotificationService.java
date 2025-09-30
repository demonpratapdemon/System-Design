package EmailNotificationWithAsynRetryMechanism.service;

import EmailNotificationWithAsynRetryMechanism.entities.EmailRequest;

public interface INotificationService {
	void sendEmail(EmailRequest request);
}
