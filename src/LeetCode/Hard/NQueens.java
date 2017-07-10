package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;
/*
 * n���ʺ�[����n*n����P��
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[] loc = new int[n]; // ӛ䛻ʺ�̎���һ�У��Д��M
		
		dfs(result, loc, 0, n);
		return result;
	}
    
	/**
	 * dfs��ѭ����ָ��һ����ӵ�һ�е����һ�з��õ����п��ܣ�
	 * ������õĵص�ͨ��isValid��֤��ͨ��cur+1������һ�н��е�
	 * �飬 ���ûͨ����֤������һ��λ�ã��������λ�ö���Valid��
	 * ������һ��
	 * @param result �惦�Y��
	 * @param loc ���loc�ۣ������¼���ǽ����Ϣ������н⣩
	 *        ���ǰ���ת����String, ���Board����
	 * @param cur Ŀǰ�[���ڎׂ��ʺ�
	 * @param n ��Ҫ�[�ׂ��ʺ�
	 */
	void dfs(List<List<String>> result, int[] loc, int cur, int n) {
		if(cur == n) {
			//�ʺ��ѽ��[��������ˣ��ʹ�ӡ��P
			printBoard(result, loc, n);
		} else {
			//�������еĴ���[�Żʺ�
			for(int i = 0; i < n; i ++) {
				loc[cur] = i;
				if(isValid(loc, cur)) {
					dfs(result, loc, cur + 1, n); 
					/* �ٷŻʺ�m+1, ����ʺ�m+1���겢������    
                                                 ���ֿ��ܣ�  
                               1.��ͻ��������
                               2.һֱ�����еĻʺ�ȫ�����겢��ȫ������    
                                                 ���ʺ�m���ݣ�̽���µĿ��ܻ��߰�ȫ��λ��  
					 */
				}
				
			}
		}
	}
	
	//��ӡ����һ�N��P�Y��
	void printBoard(List<List<String>> result, int[] loc, int n) {
		List<String> answer = new ArrayList<>();
		for(int i = 0; i < n; i ++) { //n*n
			String row = new String(); //�еĽY��
			for(int j = 0; j < n; j ++) {
				if(j == loc[i]) {
					row += "Q";
				} else {
					row += ".";
				}
			}
			answer.add(row);
		}
		
		result.add(answer);
	}
	
	boolean isValid(int[] loc, int cur) {
		//���C����ӵĻʺ��c��Щ�Ѿ�λ�Ļʺ��nͻ������Ҫ��cur�α��^
		for(int i = 0; i < cur; i ++) {
			//��C����ͬһֱ����
			if(loc[i] == loc[cur]) {
				return false;
			}
			//��֤����ͬһ�Խ����ϣ����ݶԽ������ʣ��� �� ��
			//i��Ŀǰ���L��cur��Ŀǰ�Č�
			if(Math.abs(loc[i] - loc[cur]) == (cur - i)) {
				return false;
			}
		}
		
		//��������ͬһֱ���򌦽Ǿ��ϣ��˴Δ[�Ş�Ϸ�
		return true;
	}
}