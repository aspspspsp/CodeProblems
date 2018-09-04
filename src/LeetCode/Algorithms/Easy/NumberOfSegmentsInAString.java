package src.LeetCode.Algorithms.Easy;
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        //先去除頭尾空白，避免問題
        String trimmed = s.trim();
        
        if (trimmed.length() == 0)
            return 0;
        else {
            //s+ --->至少出现一个空格
            //分割只有一個空格的字串，避免計算空格錯誤
            int segmentCounts = trimmed.split("\\s+").length;
            return segmentCounts;
        }
    }
}