package SimpleFactory;

public class Main {
	public static void main(String[] args) {
		Session session = new Session();
		Message message = MessageFactory.getMessage(session);
	}
}
