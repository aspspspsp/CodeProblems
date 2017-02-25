
public class A {
	public static void main(String[] args) {
		String word = "c";
		int processedWord = 0;
	    for (int i = 0; i < word.length(); i ++) {
	    	System.err.println((1 << word.charAt(i) - 'a') + "test");
	    	processedWord |= (1 << word.charAt(i) - 'a');
	    }
	    System.err.println("--");
	    System.err.println(processedWord);
	}
}
