package LeetCode.Easy;
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int [] {1};
        }
        
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for(int i = digits.length - 1; i >= 1; i --) {
            if(i - 1 >= 0 && digits[i] == 10) {
                digits[i - 1] = digits[i - 1] + 1;
                digits[i] = digits[i] % 10;
            }
        }
        
        int[] result;
        if(digits[0] == 10) {
            result = new int[digits.length + 1];
            for(int i = digits.length; i >= 1; i --) {
                result[i] = digits[i - 1];
            }
            result[1] = result[1] % 10;
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}