package Medium;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        
        //將每個word先做預處理(以二進制儲存)
        int[] preprocessed_words = new int[words.length];
        for(int i = 0; i < words.length; i ++) {
            preprocessed_words[i] = 0;
            //逐字對這個word進行編碼
            for(int j = 0; j < words[i].length(); j ++) {
                //(words[i].charAt(j) - 'a')將字母轉為數字 ex:a->0 b->1 etc...
                /*(1 << 字母代表的數字)是為了將數字轉為二進制後的數字
                ex: 0->1 1->2 2->4 3->8
                */
                preprocessed_words[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        
        //對每個word逐個做比較
        int max_product = 0;
        for(int i = 0; i < words.length; i ++) {
            for(int j = 0; j < words.length; j ++) {
                //對字兩個編碼(二進制)進行and運算，若為0(表示都沒有一個字相同)
                if((preprocessed_words[i] & preprocessed_words[j]) == 0) {
                    if(words[i].length() * words[j].length() > max_product)
                        max_product = words[i].length() * words[j].length();
                }
            }
        }
        
        return max_product;
    }
}