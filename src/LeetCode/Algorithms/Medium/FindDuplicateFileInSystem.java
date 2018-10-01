package src.LeetCode.Algorithms.Medium;

import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();

        // �B�z�ҥ~
        if(paths == null || paths.length == 0)
            return result;

        // <content, paths> �ɮפ��e����A�ɮ׸��|���
        Map<String, List<String>> map = new HashMap<>();

        // ���������ƪ��ɮפ��e�A�H���ɳt��
        Set<String> duplicates = new HashSet<String>();

        // ���M�Ҧ����ɤθ��|
        for(String path : paths) {
            // ������e���|�P�Ҧ�����
            String[] _ = path.split(" ");
            String prefix = _[0];

            // �����Ҧ����ɤΤ��e
            for(int i = 1; i < _.length; i ++) {
                String[] __ = _[i].split("\\(");
                String absolutePath = prefix + "/" + __[0];
                String content = __[1].substring(0, __[1].length() - 1);

                // �N��e���ɩ�JhashMap�HSet
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

        // ��쭫�ƪ����ɸ��|�A�ñN���̿�X�쵲�G��
        for(String duplicate : duplicates) {
            List<String> list = map.get(duplicate);
            result.add(list);
        }

        return result;
    }
}
