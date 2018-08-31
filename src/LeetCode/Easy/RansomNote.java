package src.LeetCode.Easy;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<String, Integer> charsNumForRansomNote = getCharNums(ransomNote);
        HashMap<String, Integer> charsNumForMagazine = getCharNums(magazine);
        
        for(String key: charsNumForRansomNote.keySet()) {
        	Integer charNumForRansomNote = charsNumForRansomNote.get(key);
        	Integer charNumForMagazine = charsNumForMagazine.get(key);
        	
        	//���s�I�Л]�а����@����ĸ�t����false
        	if(charNumForMagazine == null)
        		return false;
        	
        	//���s�I�е���ĸ<��Ҫ�õ�����ĸ�t����false
        	if(charNumForRansomNote > charNumForMagazine)
        		return false;
        }
        
        return true;
    }
    
    HashMap<String, Integer> getCharNums(String notes) {
    	HashMap<String, Integer> charsNum = new HashMap<String, Integer>();
    	for(int i = 0; i < notes.length(); i ++) {
        	String cur = notes.substring(i, i + 1);
            if(charsNum.containsKey(cur) == false) {
            	charsNum.put(cur, 1);
            } else {
            	int num = charsNum.get(cur);
            	num = num + 1;
            	charsNum.put(cur, num);
            }
        }
    	return charsNum;
    }
}
