package Medium;
/*
 * 题意：给定一个数组，让你求最大摆动序列长度。摆动序列定义为序列中任意相邻的三个数中abc，均有 a < b , b >c 或者a>b b<c
 * Ex: 1 3 2 5 4
 * 
 * 我们只要找出数组中的“拐点” 即可
 * 例子:
 * 4 5 6  3 2 1这几个数中，4为起点，那么5和6中，我们肯定选6啊~因为之后的数要求小于5，
 * 小于5的必定也小于6 比如改为4 5 6 5，之前要是选5就没办法继续往下了...
 * 总之就是选最小的和选最大的（也就是拐点） 保证不丢最优解(貪心法)
 * 
 */
public class WiggleSubsequence {
		
	public int wiggleMaxLength(int[] nums) {
		
		if(nums.length == 0)
			return 0;
		
		int length = nums.length;
		
		//若有一個數字，則長度至少為1
		int answer = 1;
		
		for(int i = 1; i < length; i ++) {
			int j = i - 1;//為第i個數字的前1個
			
			//若前一個數字小於後一個數字(為上升)
			if(nums[j] < nums[i]) {
				
				//使答案增加1
				answer = answer + 1;
				
				//尋找下降的位置
				while((i + 1) < length && nums[i] <= nums[i + 1]) {
					i = i + 1; //若第i個數不是開始下降則將i + 1
				}
			
			//若前一個數字大於後一個數字(為下降)
			} else if(nums[j] > nums[i]) {
				
				//使答案增加1
				answer = answer + 1;
				
				//尋找上升的位置
				while((i + 1) < length && nums[i] >= nums[i + 1]) {
					i = i + 1;//若第i個數不是開始上升則將i + 1
				}
			}
		}
		
		return answer;
    }
}
