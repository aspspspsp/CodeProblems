package Medium;
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String [] splits = s.split(" ");
        
        for(int i = 0; i < splits.length / 2; i ++) {
            int j = splits.length - i - 1;
            splits = swap(splits, i , j);
        }
        
        
        String ans = "";
        for(int i = 0; i < splits.length; i ++) {
            if(splits[i].equals(""))
                continue;
            ans = ans + " " + splits[i];
        }
        
        return ans.trim();
    }
    
    String[] swap(String[] splits, int i, int j) {
        String tmp = splits[i];
        splits[i] = splits[j];
        splits[j] = tmp;
        return splits;
    }
}