package src.LeetCode.Algorithms.Medium;

import java.util.Objects;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		Objects.requireNonNull(num);

		if (k == 0) {
			return num;
		}
		
		if (num.length() == 1 && k == 1) {
			return "0";
		}
		
		int pre = 0;
        int cur = 1;
		StringBuilder sb = new StringBuilder(num);
        // 從左到右，刪除左邊比右邊鄰居大 ex: 65 刪除6
		while (k > 0 && cur < sb.length()) {
			if (sb.charAt(cur) < sb.charAt(pre)) {
				sb.deleteCharAt(pre);
				if (pre > 0) {
					//我们现在需要比较被删除的那一個元素的左邻居和右邻居
					pre --;
					cur --;
				}

				k --;
			} else {
				// moving forward if element in cur is greater than element at pre cursor
				pre = cur;
				cur ++;
			}
		}
        
		// last pass might not remove enough characters
		int rightPosition = sb.length() - 1;
		// then need to go through it from right to left and remove the right most
		// non-zero one
		while (k > 0 && rightPosition >= 0) {
			if (sb.charAt(rightPosition) != '0') {
				sb.deleteCharAt(rightPosition);
				k --;
			}
			rightPosition --;
		}
        
        //刪除第一個0與其他接在它後面的0
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		
		if(sb.length() == 0) {
			return "0";
		}
		
		return sb.toString();
	}
}