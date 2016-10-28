package Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        //創建一個hashMap 以便記錄每個數字出現的次數
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		//統計數字出現的頻率
        for(int i = 0; i < nums.length; i ++) {
        	Integer num = hashMap.get(nums[i]);
        	if(num == null) {
        		hashMap.put(nums[i], 1);
        	} else {
        		num = num + 1;
        		hashMap.put(nums[i], num);
        	}
        }
        
        //創建一個可排序的List:sortedNums(LeetCode使用Entry需要前面引用Map)
        List<Map.Entry<Integer, Integer>> sortedNums = new ArrayList<Map.Entry<Integer, Integer>>();
        
        //將hashMap的元素全部加入sortedNums
        sortedNums.addAll(hashMap.entrySet());
        
        //排序(利用歸併排序)
        Collections.sort(sortedNums, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				return  e2.getValue() - e1.getValue();
				//e2-e1由大到小
				//e1-e2由小到大
			}
        });
        
        //創建結果list
        List<Integer> result = new ArrayList<Integer>();
        
        //輸出前k個結果
        for(int i = 0; i < k; i ++) {
        	result.add(sortedNums.get(i).getKey());
        }
        
        //返回答案
        return result;
    }
}