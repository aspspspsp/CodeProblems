package LeetCode.Easy;
/*
�ⷨ������������һ�����ɣ���1��9����9��ֻռ1��λ�������֣�
���ָ���Ϊ10 - 1 + 1����10��99����90��ռ2��λ�������֣���
�ָ���Ϊ99 - 10 + 1����˿��Եõ������Ĺ��ɣ�
��Χ	    ռλ	����	        ��ռλ
1����9	    1	    9-1+1 = 9       9*1=9
10����99	    2	    99-10+1=90	    90*2=180
100����999	3	    999-100+1=900	900*3=2700
����			
��ˣ����Ҫ���յ�n�������֣�����Ҫ�������������ĸ�����
��Χ���ڸ÷�Χ��ÿ��ʵ�ʵ�����ռ����λ�������Χ�ڵ�һ��
ʵ������ǰ�Ѿ�ռ���˶��ٸ������֡�Ȼ�󣬸�����Щ�������
�����ֵ��
*/
public class NthDigit {
    public int findNthDigit(int n) {
        // �÷�Χ������ʵ�����ֶ�ռ����digit��������
        int digit = 1;
        // �÷�Χ֮ǰ������ʵ�������Ѿ�ռ����totalDigit��������
        long totalDigit = 0;
        // �Ȳ�����䷶Χ
        while(true) {
            //�����һ������λ
            long top = totalDigit + digit * 9 * (long)Math.pow(10, digit - 1);
            //��n�څ^�g�Ȅt����
            if(n >= totalDigit && n <= top) {
                break;
            }
            
            //�M����һ����λ
            totalDigit = top;
            digit ++;
        }
        
        // ���ݷ�Χ��������ֵ
        int start = (int) Math.pow(10, digit - 1);
        int ret = 0;
        totalDigit += 1;
        
        // ��n��digit���ĸ������ʵ��������
        int value = start + (n - (int)totalDigit) / digit;
        
        //ȡ�õ�nλ��
        ret = Integer.toString((int)value).charAt(((int)(n - totalDigit) % digit)) - '0';
        return ret;
    }
}