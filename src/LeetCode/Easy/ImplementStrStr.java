package LeetCode.Easy;
//strstr()�������������Ӵ����ַ������״γ��ֵ�λ�ã���ԭ��Ϊ��
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        //haystack(�����ҵ��ַ���)�Ĵ�С
        int length1 = haystack.length();
        //needle(Ҫ���ҵ��ַ���)�Ĵ�С
        int length2 = needle.length();
        
        //haystack���L��С�needle���L�ȱ�ʾhaystack�Q�����ܰ���needle
        if(length1 < length2)
            return -1;
        //��needle���L�Ȟ�0�����Ա�ʾ��һ�_ʼ��ƥ��
        else if(length2 == 0)
            return 0;
        
        //�_ʼƥ���ַ���
        
        //����ƥ�䳬�^haystack���L�Ȍ����e�`
        int matching_threshold = length1 - length2;
        
        for(int i = 0; i <= matching_threshold; i ++) {
            //��ƥ��
            if(haystack.substring(i, i + length2).equals(needle))
                return i;
        }
        
        //ƥ�䲻���t����-1
        return -1;
    }
}