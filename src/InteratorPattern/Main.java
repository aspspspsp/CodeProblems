package InteratorPattern;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int n = m.get();
		System.err.print(n);
	}
	
	public int get() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}
	
}
