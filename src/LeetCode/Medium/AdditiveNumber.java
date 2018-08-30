package src.LeetCode.Medium;

/*
���⣺
����һ���ַ����������ж��Ƿ���԰�˳�򻮷ֳ�ŵ�ɸ������������ϣ�������ǰ����������͵��ڵ���������
��112358����Ϊ1��1��2��3��5��8ǡ�����㡣
ע�⣬���ֵ����ֲ�����ǰ��0
*/

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        /*
        ��num��һ�з֞�ɷ�=>
        ex:123456
        1(��0~i), 2(��i+1~j) .....(����)
        */
        for(int i = 1; i < num.length(); i ++) {
            // 避免出現0為首的數字 例如:010
            if(num.charAt(0) == '0' && i > 1)
                continue;
            
            for(int j = i + 1; j < num.length(); j ++) {
                //���˔���0�_�^�s���0�Ĕ� ex:010���t���^
                if(num.charAt(i) == '0' && j - i > 1)
                    continue;
                //��num��һ�з֞�ɷ�=>ex: 1(��0~i), 2(��i+1~j) .....(����)
                if(dfs(num, 0, i, j) == true)
                    return true;
            }
        }
        return false;
    }
    
	// 判斷從[i,j)和[j,k)出發，能否走到盡頭
    boolean dfs(String num, int i, int j, int k) {
        // [i, j)
        long num1 = Long.parseLong(num.substring(i, j));
        // [j, k)
        long num2 = Long.parseLong(num.substring(j, k));
        
        // 兩數進行相加
        String addition = String.valueOf(num1 + num2);
        
        //num.substring(k)�@ʾ��k�_ʼ���Yβ������
        //num.startsWith(addition) num�Ƿ��а�����addition��ǰ�Y
        
        //�z��ǰ��ɂ����ĺ��Ƿ��춵�������
        if(num.substring(k).startsWith(addition) == false)
            return false;
        
        //�ѽ���ɗl��
        if(k + addition.length() == num.length())
            return true;
        
        //�^�m��������(��j~k, k~֮�ᣬ�_ʼ)
        return dfs(num, j, k, k + addition.length());
    }
}