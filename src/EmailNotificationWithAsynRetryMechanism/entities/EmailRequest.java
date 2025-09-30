package EmailNotificationWithAsynRetryMechanism.entities;

public class EmailRequest {
	private String to, from;
	private String subject;
	private String body;

	public EmailRequest(String to, String from, String subject, String body) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", from=" + from + ", subject=" + subject + ", body=" + body + "]";
	}

}
