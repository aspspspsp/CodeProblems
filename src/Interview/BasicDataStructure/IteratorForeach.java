package Interview.BasicDataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class IteratorForeach {
	public static void main(String[] args) {
		System.err.println("Stack歷遍");
		//Stack歷遍
		Stack<String> stack = new Stack<>();
		stack.add("test1");
		stack.add("test2");
		stack.add("test3");
		stack.add("test4");
		stack.add("test5");
		foreach(stack);
		
		System.err.println("Queue歷遍");
		//Stack歷遍
		Queue<String> queue = new LinkedList<>();
		queue.add("test1");
		queue.add("test2");
		queue.add("test3");
		queue.add("test4");
		queue.add("test5");
		foreach(queue);
		
		System.err.println("LinkedList歷遍");
		//LinkedList歷遍
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("test1");
		linkedList.add("test2");
		linkedList.add("test3");
		linkedList.add("test4");
		linkedList.add("test5");
		foreach(linkedList);
		
		System.err.println("ArrayList歷遍");
		//ArrayList歷遍 <-線程不安全
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("test1");
		arrayList.add("test2");
		arrayList.add("test3");
		arrayList.add("test4");
		arrayList.add("test5");
		foreach(arrayList);
		
		System.err.println("Vector歷遍");
		//Vector歷遍 <-線程安全
		Vector<String> vector = new Vector<>();
		vector.add("test1");
		vector.add("test2");
		vector.add("test3");
		vector.add("test4");
		vector.add("test5");
		foreach(vector);
		
		System.err.println("HashSet歷遍");
		//HashSet歷遍
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("test1");
		hashSet.add("test2");
		hashSet.add("test3");
		hashSet.add("test4");
		hashSet.add("test5");
		foreach(hashSet);
		
		System.err.println("HashMap歷遍");
		//HashMap
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "test1");
		hashMap.put(2, "test2");
		hashMap.put(3, "test3");
		hashMap.put(4, "test4");
		hashMap.put(5, "test5");
		foreach(hashMap);
		
		System.err.println("Hashtable歷遍");
		//Hashtable
		Hashtable<Integer, String> hashTable = new Hashtable<>();
		hashTable.put(1, "test1");
		hashTable.put(2, "test2");
		hashTable.put(3, "test3");
		hashTable.put(4, "test4");
		hashTable.put(5, "test5");
		foreach(hashTable);
	}
	
	public static void foreach(Collection<String> collection) {
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.err.println(iterator.next());
		}
	}
	
	public static void foreach(Map<Integer, String> map) {
		for(Integer key : map.keySet()) {
			System.err.println(map.get(key));
		}
	}
}
