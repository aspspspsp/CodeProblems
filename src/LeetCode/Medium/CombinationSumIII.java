package LeetCode.Medium;
/*
 * ���û��ݷ��������
 * 
 * Ex:1 2 3, 1 3 4...
 * 	  2 3 4, 2 4 5...
 *    3 4 5....
 * 
*/
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII{
	public List<List<Integer>> combinationSum3(int k, int n) {
		
		//���Y��
		List<List<Integer>> result = new LinkedList<>();
		
		//�н�Y��
		List<Integer> middleRes = new LinkedList<Integer>();
		
		slove(k, 1, n, 0, result, middleRes);
		
		return result;
    }
	
	//��kλ,Ŀǰ�Ļغϔ�(Ŀǰ�ֽ���kλ),�N��(�]�б��ֽ���N��),��һ����m,�Y��,�н�Y��
	public void slove(int k, int cur, int reminder, int prevValue, List<List<Integer>> result, List<Integer> middleRes) {
		
		//��Ŀǰ�ֽ�Ĕ��]��С�Kλ
		if(k > cur) {
			
			//����һ���ֽ�Ĕ� ��9����(9 - (k - cur))�Ǽ��٣�����i����һ��Ҫ��9 - (k - cur)����ȼ���������9��
			for(int i = prevValue + 1; i <= (9 - (k - cur)); i ++) {
				
				//��"�н�"�����@����
				middleRes.add(i);
				
				//�f�w����һ���^��
				slove(k, cur + 1, reminder - i,  i, result, middleRes);
				
				//��"�н�"�hȥ��������Ĕ�(����ǂ�ַ�������h���������e)
				middleRes.remove(middleRes.size() - 1);
			}
		
		//���ѽ��ֽ�Ĕ��_��Kλ
		} else {
			
			//�N��һ��Ҫ�����һ����(�}ĿҪ��)�����N��С�9(�}ĿҪ��)
			if(reminder > prevValue && reminder <= 9) {
				//��"�н�"��������һ����reminder(�N��)
				middleRes.add(reminder);
				
				//��"�н�"�Y������}�u
				List<Integer> res = new LinkedList<Integer>();
				for(int i = 0; i < middleRes.size(); i++) {
					res.add(middleRes.get(i));
				}
				
				//���}�u���"�н�"�Y������Y��
				result.add(res);
				
				//��"�н�"�hȥ��������Ĕ�(����ǂ�ַ�������h���������e)
				middleRes.remove(middleRes.size() - 1);
			}
		}
	
	}
}
