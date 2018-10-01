package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();

        // 處理例外
        if(paths == null || paths.length == 0)
            return result;

        // <content, paths> 檔案內容當鍵，檔案路徑當值
        Map<String, List<String>> map = new HashMap<>();

        // 紀錄有重複的檔案內容，以提升速度
        Set<String> duplicates = new HashSet<String>();

        // 歷遍所有文檔及路徑
        for(String path : paths) {
            // 切分當前路徑與所有文檔
            String[] _ = path.split(" ");
            String prefix = _[0];

            // 切分所有文檔及內容
            for(int i = 1; i < _.length; i ++) {
                String[] __ = _[i].split("\\(");
                String absolutePath = prefix + "/" + __[0];
                String content = __[1].substring(0, __[1].length() - 1);

                // 將當前文檔放入hashMap以Set
                if(map.containsKey(content) == false) {
                    List<String> pathList = new ArrayList<>();
                    pathList.add(absolutePath);
                    map.put(content, pathList);
                } else {
                    List<String> pathList = map.get(content);
                    pathList.add(absolutePath);
                    map.put(content, pathList);
                    duplicates.add(content);
                }
            }
        }

        // 找到重複的文檔路徑，並將它們輸出到結果當中
        for(String duplicate : duplicates) {
            List<String> list = map.get(duplicate);
            result.add(list);
        }

        return result;
    }
}
