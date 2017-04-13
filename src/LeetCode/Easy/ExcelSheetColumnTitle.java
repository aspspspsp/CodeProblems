package LeetCode.Easy;
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        
        String result = "";
        while(n > 26) {
            int charId = n % 26;
            if(charId == 0)
                charId = 26;
                
            n = (n - charId) / 26;
            result = (char)(charId + 64) + result;
        }
        
        int charId = n % 26;
        if(charId == 0)
                charId = 26;
        result = (char)(charId + 64) + result;
        
        return result;
    }
}