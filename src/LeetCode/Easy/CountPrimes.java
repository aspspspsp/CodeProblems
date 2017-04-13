package LeetCode.Easy;

/*
���⣺�ҳ�����С�� n ��������
��Ŀ�ܼ�࣬�����㷨ʵ�ֵ��Ż�����кܶ�㡣��������Ҫ˼����ǲ��� Sieve of Eratosthenes �㷨�����
��˼·Ϊ��
1.�ҳ�n��Χ�����к�����������ǡ�(2<=i<=n)
2.δ����ǵļ�Ϊ������ͳ��δ����ǵ���������Ϊԭ��Ŀ�⡣
(����2ȥ�Y������2���£���2�ı����޳�����
������һ���|����Ҳ����3�Y����3���£���3�ı����޳�����
����ȥ����һ���|��5�Y����5���£���5�ı����޳������������}��ȥ......��)
*/

public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        
        //��n��prime��ӛ̖
        boolean[] prime = new boolean[n];
        
        /////���On���µ����Д������ؔ�
        for(int i = 2; i < n; i ++) {
            prime[i] = true;
        }
        
        /////�ҵ������ؔ��Ĕ�
        //�v��2~(n-1)^0.5
        for(int i = 2; i <= Math.sqrt(n - 1); i ++) { // or for(int i = 2; i <= n - 1; i ++)
            //��ӛi�ı��������ؔ�(����:i*2~i<n)������i������ؔ�
            if(prime[i] == true) {
                for(int j = i * 2; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        /////�yӋ��1~(n-1)���е��ؔ�
        int count = 0;
        for(int i = 2; i < n; i ++) {
            if(prime[i] == true) {
                count ++;
            }
        }
        
        return count;
    }
}