package src.LeetCode.Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//紀錄每個元素出現次數的hashMap
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		//歷遍nums，並且記錄他們所出現的次數
        for(int i = 0; i < nums.length; i ++) {
        	Integer num = hashMap.get(nums[i]);
        	if(num == null) {
        		hashMap.put(nums[i], 1);
        	} else {
        		num = num + 1;
        		hashMap.put(nums[i], num);
        	}
        }
        
		//宣告一個可以將hashMap排序的list(利用list 可以被Collections.sort排序的特性)
        List<Map.Entry<Integer, Integer>> sortedNums = new ArrayList<Map.Entry<Integer, Integer>>();
        
		//將hashMap的所有元素加入可被排序的List
        sortedNums.addAll(hashMap.entrySet());
        
		//將這個sortedNums排序(也就是將這個hashMap按照value來排序)
        Collections.sort(sortedNums, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				return  e2.getValue() - e1.getValue();
				//e2-e1由大到小
				//e1-e2由小到大
			}
        });

        //這個list是用以存儲結果
        List<Integer> result = new ArrayList<Integer>();
        
        //取得topK
        for(int i = 0; i < k; i ++) {
        	result.add(sortedNums.get(i).getKey());
        }
        
        //返回結果
        return result;
    }
}