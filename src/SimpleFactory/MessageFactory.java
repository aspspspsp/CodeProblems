package SimpleFactory;

public class MessageFactory {
	public static Message getMessage(Session session) {
		Message msg = new MimeMessage();
		msg.setForm(new InternetAddress(session.form));
		msg.setSubject(session.subject);
		msg.setText(session.text);
		msg.setHeader(session.headerName, session.headerValue);
		msg.setDate(session.date);
		
		return msg;
	}
}
