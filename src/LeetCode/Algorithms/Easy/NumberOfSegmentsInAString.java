package src.LeetCode.Algorithms.Easy;
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        //��ȥ���^β�հף����↖�}
        String trimmed = s.trim();
        
        if (trimmed.length() == 0)
            return 0;
        else {
            //s+ --->���ٳ���һ���ո�
            //�ָ�ֻ��һ���ո���ִ�������Ӌ��ո��e�`
            int segmentCounts = trimmed.split("\\s+").length;
            return segmentCounts;
        }
    }
}