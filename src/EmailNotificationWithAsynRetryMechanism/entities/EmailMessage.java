package EmailNotificationWithAsynRetryMechanism.entities;

import java.util.UUID;

import EmailNotificationWithAsynRetryMechanism.enums.MessageStatus;

public class EmailMessage {

	@SuppressWarnings("unused")
	private String msgId;
	private EmailRequest request;
	private int retryCount;
	private MessageStatus status;

	public EmailMessage(EmailRequest request, int retryCount, MessageStatus status) {
		this.msgId = UUID.randomUUID().toString();
		this.request = request;
		this.retryCount = retryCount;
		this.status = status;
	}

	public EmailRequest getRequest() {
		return request;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public void setRequest(EmailRequest request) {
		this.request = request;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}
	
	

}
