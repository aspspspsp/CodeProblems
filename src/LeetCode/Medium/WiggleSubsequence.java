package LeetCode.Medium;
/*
 * ���⣺����һ�����飬���������ڶ����г��ȡ��ڶ����ж���Ϊ�������������ڵ���������abc������ a < b , b >c ����a>b b<c
 * Ex: 1 3 2 5 4
 * 
 * ����ֻҪ�ҳ������еġ��յ㡱 ����
 * ����:
 * 4 5 6  3 2 1�⼸�����У�4Ϊ��㣬��ô5��6�У����ǿ϶�ѡ6��~��Ϊ֮�����Ҫ��С��5��
 * С��5�ıض�ҲС��6 �����Ϊ4 5 6 5��֮ǰҪ��ѡ5��û�취����������...
 * ��֮����ѡ��С�ĺ�ѡ���ģ�Ҳ���ǹյ㣩 ��֤�������Ž�(؝�ķ�)
 * 
 */
public class WiggleSubsequence {
		
	public int wiggleMaxLength(int[] nums) {
		
		if(nums.length == 0)
			return 0;
		
		int length = nums.length;
		
		//����һ�����֣��t�L�����ٞ�1
		int answer = 1;
		
		for(int i = 1; i < length; i ++) {
			int j = i - 1;//���i�����ֵ�ǰ1��
			
			//��ǰһ������С���һ������(������)
			if(nums[j] < nums[i]) {
				
				//ʹ������1
				answer = answer + 1;
				
				//�����½���λ��
				while((i + 1) < length && nums[i] <= nums[i + 1]) {
					i = i + 1; //����i���������_ʼ�½��t��i + 1
				}
			
			//��ǰһ�����ִ����һ������(���½�)
			} else if(nums[j] > nums[i]) {
				
				//ʹ������1
				answer = answer + 1;
				
				//����������λ��
				while((i + 1) < length && nums[i] >= nums[i + 1]) {
					i = i + 1;//����i���������_ʼ�����t��i + 1
				}
			}
		}
		
		return answer;
    }
}
