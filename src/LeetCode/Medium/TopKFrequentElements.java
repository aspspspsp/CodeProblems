package LeetCode.Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        //����һ��hashMap �Ա�ӛ�ÿ�����ֳ��F�ĴΔ�
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		//�yӋ���ֳ��F���l��
        for(int i = 0; i < nums.length; i ++) {
        	Integer num = hashMap.get(nums[i]);
        	if(num == null) {
        		hashMap.put(nums[i], 1);
        	} else {
        		num = num + 1;
        		hashMap.put(nums[i], num);
        	}
        }
        
        //����һ���������List:sortedNums(LeetCodeʹ��Entry��Ҫǰ������Map)
        List<Map.Entry<Integer, Integer>> sortedNums = new ArrayList<Map.Entry<Integer, Integer>>();
        
        //��hashMap��Ԫ��ȫ������sortedNums
        sortedNums.addAll(hashMap.entrySet());
        
        //����(���Úw������)
        Collections.sort(sortedNums, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				return  e2.getValue() - e1.getValue();
				//e2-e1�ɴ�С
				//e1-e2��С����
			}
        });
        
        //�����Y��list
        List<Integer> result = new ArrayList<Integer>();
        
        //ݔ��ǰk���Y��
        for(int i = 0; i < k; i ++) {
        	result.add(sortedNums.get(i).getKey());
        }
        
        //���ش�
        return result;
    }
}