package Medium;
/*
 * 利用回溯法構造出答案
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
		
		//總結果
		List<List<Integer>> result = new LinkedList<>();
		
		//中介結果
		List<Integer> middleRes = new LinkedList<Integer>();
		
		slove(k, 1, n, 0, result, middleRes);
		
		return result;
    }
	
	//有k位,目前的回合數(目前分解至k位),餘數(沒有被分解的餘數),上一個數m,結果,中介結果
	public void slove(int k, int cur, int reminder, int prevValue, List<List<Integer>> result, List<Integer> middleRes) {
		
		//若目前分解的數沒有小於K位
		if(k > cur) {
			
			//從上一個分解的數 至9，而(9 - (k - cur))是加速，因為第i個數一定要是9 - (k - cur)，不燃加起來會比9大
			for(int i = prevValue + 1; i <= (9 - (k - cur)); i ++) {
				
				//在"中介"加入這個數
				middleRes.add(i);
				
				//遞歸至下一個過程
				slove(k, cur + 1, reminder - i,  i, result, middleRes);
				
				//將"中介"刪去剛剛加入的數(因為是傳址，若不刪除，會出錯)
				middleRes.remove(middleRes.size() - 1);
			}
		
		//若已經分解的數達到K位
		} else {
			
			//餘數一定要大於上一個數(題目要求)，且餘數小於9(題目要求)
			if(reminder > prevValue && reminder <= 9) {
				//在"中介"加入最後一個數reminder(餘數)
				middleRes.add(reminder);
				
				//將"中介"結果深層複製
				List<Integer> res = new LinkedList<Integer>();
				for(int i = 0; i < middleRes.size(); i++) {
					res.add(middleRes.get(i));
				}
				
				//將複製後的"中介"結果加入結果
				result.add(res);
				
				//將"中介"刪去剛剛加入的數(因為是傳址，若不刪除，會出錯)
				middleRes.remove(middleRes.size() - 1);
			}
		}
	
	}
}
