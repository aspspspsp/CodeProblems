package Interview.BasicDataStructure;

import java.util.Arrays;

public class MyList<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	
	public static void main(String[] args) {
		MyList<Integer> myList = new MyList<>();
		for(int i = 0; i < 5; i ++) {
			myList.add(i);
		}
		myList.remove(1);
		for(int i = 0; i < myList.size; i ++) {
			int ie = myList.get(i);
			System.err.println(ie);
		}
		
		System.err.println(myList.size());
	}
	
	public MyList() {
		//先設置預設大小
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public void add(E e) {
		//若表目前的大小已達極限則擴張表
		if(size == elements.length) {
			ensureCapa();
		}
		
		elements[size] = e;
		size = size + 1;
	}
	
	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if(i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
			
		return (E)elements[i];
	}
	
	public E remove(int i) {
		if(i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		
		E obj = (E) elements[i];
		
		//覆蓋掉刪除之後的部分
		while(i < size) {
			elements[i] = elements[i + 1];
			i ++;
		}
		
		size --;
		return obj;
	}
	
	public int size() {
		return size;
	}
}
