package LeetCode.Medium;
public class CoinChange {
    /*
    amount = 12
    ex: 2,5
    
    i = 0 d[0] = 0
    i = 1 d[1] = Integer.MAX_VALUE
    i = 2 d[2] = d[i - k] + 1 = d[2 - 2] + 1 = 1
    i = 3 d[3] = Integer.MAX_VALUE
    i = 4 d[4] = d[i - k] + 1 = d[4 - 2] + 1 = 2
    i = 5 d[5] = d[i - k] + 1 = d[5 - 5] + 1 = 1
    i = 6 d[6] = d[i - k] + 1 = d[6 - 2] + 1 = 3
    i = 7 d[7] = Integer.MAX_VALUE
    i = 8 d[8] = d[i - k] + 1 = d[6 - 2] + 1 = 4
    i = 9 d[9] = Integer.MAX_VALUE
    i = 10 d[2] = d[i - k] + 1 = d[10 - 2] + 1 = 5
    i = 11 d[11] = Integer.MAX_VALUE
    i = 12 d[12] = d[i - k] + 1 = d[12 - 2] + 1 = 6
    */
    public int coinChange(int[] coins, int amount) {
        int [] d = new int[amount + 1];
        
        //�M��0��ֻ��0�N��Ӳ���x��
        d[0] = 0;
        
        //1~amount���O��o�޴�(��ʾ�ȼ��O���еĔ�����Ŀǰ��Ӳ�şo���_����)
        for(int i = 1; i <= amount; i ++) {
            d[i] = Integer.MAX_VALUE;
        }
        
        //��1~amount�������еĔ��^һ��
        for(int i = 1; i <= amount; i ++) {
            //ÿ��iѭ�h�r����Ҫ�����е�Ӳ���^һ��
            for(int j = 0; j < coins.length; j ++) {
                //d[i - coins[j]] == Integer.MAX_VALUE ��ʾԓi-coins[j]�����o��
                if(i >= coins[j] && d[i - coins[j]] != Integer.MAX_VALUE) {
                    //���^d[i]�o��,�cd[i - coins[j]] + 1�Ă�С
                    d[i] = Math.min(d[i], d[i - coins[j]] + 1);
                }
            }
        }
        
        //��d[amount] == Integer.MAX_VALUE�����Ǜ]�н�
        if(d[amount] != Integer.MAX_VALUE)
            return d[amount];
        else
            return -1;
    }
}