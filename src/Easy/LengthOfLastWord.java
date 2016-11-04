package Easy;
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] allWords = s.split(" ");
        
        if(allWords.length == 0)
            return 0;
        
        String lastWord = allWords[allWords.length - 1];
        
        return lastWord.length();
    }
}