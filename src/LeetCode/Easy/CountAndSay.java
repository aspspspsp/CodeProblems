package LeetCode.Easy;
/*
1, 11, 21, 1211, 111221, ...

n = 1ʱ����ӡһ��1
n = 2ʱ����n=1��һ�У��1��1�����Դ�ӡ��11
n = 3ʱ����n=2��һ�У��2��1�����Դ�ӡ��21
n = 4ʱ����n=3��һ�У��1��2, 1��1�����Դ�ӡ��1211
     �Դ����ơ�(ע������n�Ǵ�1��ʼ�ģ�
     
    ���Թ�����ǰ�е��ַ���Ҫ������һ�е��ַ�����
��С�����������ѭ��֮��ǵð����һ���ַ�Ҳ���ϣ���Ϊ֮ǰ
   ֻ�Ǽ������ѡ���
   
   ����������ɨ��1211��ʱ�򣬿�1������2����1��count = 1��
   ��count + 1д���ַ����У�2Ҳһ����2�����1,1���滹��1��
   ��count++���ڶ���1����û���ˣ���count+1д���ַ�����
   ������ϡ�
   ��˴�ӡ�ľ���11+12+21��111221��
*/
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        
        String curResult = "1";
        
        //start = 1 ��1�_ʼ��
        for(int start = 1; start < n; start ++) {
            StringBuilder result = new StringBuilder();
            
            int count = 1;
            for(int j = 1; j < curResult.length(); j ++) {
                if(curResult.charAt(j) == curResult.charAt(j - 1)) {
                    count ++;
                } else {
                    result.append(count);
                    result.append(curResult.charAt(j - 1));
                    count = 1;
                }
            }
            
            result.append(count);
            result.append(curResult.charAt(curResult.length() - 1));
            curResult = result.toString();
        }
        
        return curResult;
    }
}
