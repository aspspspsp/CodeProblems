import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Elem{
	String key;
	String value;
}

public class A2 {

	public static Map<String, Boolean> sortMapByKey(Map<String, Boolean> oriMap){  
        if(oriMap==null || oriMap.isEmpty())  
            return null;  
        Map<String, Boolean>sortedMap = new TreeMap<String, Boolean>(new Comparator<String>(){  
            @Override  
            public int compare(String key1, String key2) { 
                return key1.compareTo(key2);  
            }  
              
        });       
        sortedMap.putAll(oriMap);  
        return sortedMap;
	}
	
	public static Map<String, Boolean> isCircle(ArrayList<Elem> map) {
		HashMap<String, Boolean> res = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<map.size(); i++) {
			set.add(map.get(i).key);
			res.put(map.get(i).key, false);
			if(set.contains(map.get(i).value))
				res.put(map.get(i).key, true);			
			else 
				res.put(map.get(i).value, false);				
			set.add(map.get(i).value);
		}
        
        return sortMapByKey(res);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		ArrayList<Elem> map = new ArrayList<>();
		String line;
		while(true) {
			line = sc.nextLine();
			if(line.charAt(line.length()-1) != ',') {
				Elem elem = new Elem();
				elem.key = line.substring(1, 5);
				elem.value = line.substring(7,11);
				map.add(elem);
				break;		
			}
			Elem elem = new Elem();
			elem.key = line.substring(1, 5);
			elem.value = line.substring(7,11);
			map.add(elem);		
		}
		
		Map<String, Boolean> res = isCircle(map);
		StringBuilder sb = new StringBuilder();
		for(String key : res.keySet()) 
			sb.append("{" + key + ", " + res.get(key) + "},\n");
		System.out.println(sb.toString().substring(0, sb.length()-2));
	}

}
