package LeetCode.Medium;
/*
��֮ǰ�ĳ����}Ŀ��ͬ���ǣ�֮ǰ������Ǵ�2��3��5���ң��������Ǹ�����������������ǵı����ĳ�������
�������Ͽ�������������������ǲ�֪�������ĸ��������ǿ�����һ��idx���������浱ǰ��λ�ã�Ȼ�����Ǵ�
ÿ��������ȡ��һ�������ҳ�������Сֵ��Ȼ�����idx�����Ӧλ�ã�ע���п�����Сֵ��ֹһ����Ҫ������
����Сֵ��λ��
*/
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {        
        int[] dp = new int[n];
        
        //��һ���h����1
        dp[0] = 1;
                
        int[] idxPrimes = new int[primes.length];
        int counter = 1;
        while(counter < n) {
            //�o���Сֵ
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < primes.length; i ++) {
                //idxPrimes[i] ����ÿ���h���Ă���
                //����:�h����2,3,5
                //idxPrimes[0] => 2����
                //idxPrimes[1] => 3����
                //idxPrimes[2] => 5����
                int temp = dp[idxPrimes[i]] * primes[i];
                
                //��temp���ҵ���С��
                if(temp < min)
                    min = temp;
            }
            //���min == dp[idxPrimes[i]] * primes[i]���t��������
            for(int i = 0; i < primes.length; i ++) {
                if(min == dp[idxPrimes[i]] * primes[i]) {
                    idxPrimes[i] ++;
                }
            }
            dp[counter] = min;
            counter ++;
        }
        return dp[n - 1];
    }
}