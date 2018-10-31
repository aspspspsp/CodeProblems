package src.LeetCode.Algorithms.Medium;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0)
            return 0;

        // 先利用"\n"做切割，將路徑中所有資料夾或文檔名稱切割出來
        String[] lines = input.split("\n");

        int max_length = 0; // 記錄路徑最大長度
        int[] dp = new int[input.length() + 1]; // 記錄所有深度的路徑長度

        // 歷遍所有資料夾或文檔
        for(String line : lines) {
            /*
            lastIndexOf是記錄該文字最後出現的索引，
            我們利用這個特性來記錄目前文檔所處於的路
            徑深度
            */
            int level = line.lastIndexOf("\t") + 2; // 記錄當前目錄深度
            int len = line.length() - (level - 1); // 記錄當前檔案名稱或是文件夾名稱長度

            // 若當前名稱為"文檔"，我們則開始對其比較是否為最大長度
            if(line.contains(".") == true) {
                max_length = Math.max(max_length, dp[level - 1] + len);
            }
            // 若不是文檔，則記錄當前路徑名稱長度
            else {
                dp[level] = dp[level - 1] + len + 1; // +1代表"/"的長度
            }
        }

        return max_length;
    }
}
