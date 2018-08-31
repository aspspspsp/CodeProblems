package src.LeetCode.Medium;

/*

The key observation is pow(a,b)%1337 = pow(1337*k+a,b) % 1337

1. a^b % 1337 = (a%1337)^b % 1337
2. xy % 1337 = ((x%1337) * (y%1337)) % 1337, ����xy��һ��������:45, 98�ȵ�
b�ı�ʾ��ʽ��[1,0] = 10
*/

public class SuperPow {
    public int superPow(int a, int[] b) {
        int result = 1;
        for(int i = 0; i < b.length; i ++) {
            //ÿ���Ƶ���һλ�r��Ҫ^10
            result = pow(result, 10) * pow(a, b[i]) % 1337;
        }
        
        return result;
    }
    
    //a^b % 1337 = (a%1337)^b % 1337
    public int pow(int x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x % 1337;
        
        //a^b % 1337 = (a%1337)^b % 1337
        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
    }
    
}