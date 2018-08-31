package src.LeetCode.Algorithms.Easy;

public class DetectCapital {
	/*
	 * 檢測單詞是否符合下面規則:
	 * 全小寫:test
	 * 全大寫:TEST
	 * 首字大寫:Test
	 * 
	 * 将单词转换为大写得到up，将单词转换为小写得到low
	 * 若word与up或与low相等，则返回true，否则去掉word
	 * 的首字母得到last，若last转换为小写后仍与last相等，
	 * 则返回true，否则返回false。
	 */
    public boolean detectCapitalUse(String word) {
        int length = word.length();
        String up = word.toUpperCase();
        String low = word.toLowerCase();
        
        //符合全大寫或是全小寫的規則
        if(word.equals(low) || word.equals(up))
            return true;
        
        String last = word.substring(1, length); //取得最後一個字母
        if(last.toLowerCase().equals(last))
            return true;
        
        return false;
    }
}
