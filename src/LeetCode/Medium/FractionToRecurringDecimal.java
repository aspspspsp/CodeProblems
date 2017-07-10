package LeetCode.Medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	/* Given numerator = 1, denominator = 2, return "0.5".
       Given numerator = 2, denominator = 1, return "2".
       Given numerator = 2, denominator = 3, return "0.(6)". 
               ��ѭ�h�Ĳ�����̖����
	 */
    public String fractionToDecimal(int numerator, int denominator) {
        //��������0ֱ�ӷ���0
        if(numerator == 0)
            return "0";
        
        //������0�t�]�нY��
        if(denominator == 0)
            return "";
        
        String result = "";
        //̎��Y����ؓ������r
        if((numerator < 0) ^ (denominator < 0))
            result += "-";
        
        //��int�̈́e�D�Q��long���K������ȫ����������̎��
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        //����
        long res = num / den;
        result += String.valueOf(res);
        
        //���N��
        long remainder = (num % den) * 10;
        
        //���N����0����ֱ�ӷ��ؽY��
        if(remainder == 0)
            return result;
        
        //�M��С���Ĳ���
        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";
        while(remainder > 0) {
            //����ѭ�hС��
            if(map.containsKey(remainder)) {
            	//ȡ��ѭ�hС����λ��
                int beg = map.get(remainder);
                
                //��ѭ�hС���c��ѭ�h�Ĳ���ƴ������
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            
            //���]�Єt�^�m�����N��������t�^�m
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        
        return result;
    }
}