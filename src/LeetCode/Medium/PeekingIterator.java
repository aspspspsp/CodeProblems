package LeetCode.Medium;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator iterator; //存放所有的值
    Integer nextElement; //存放下一個值
    
    //初始化
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    
	    //取出輸入內所有存放的值，然後存進interator
	    this.iterator = iterator;
	    
	    if(iterator.hasNext() == true) {
	        this.nextElement = iterator.next();
	    } else {
	        this.nextElement = null;
	    }
	}

    //取出下一個值，但指針不移到下一個值ֵ
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.nextElement;
	}
    
    //取出下一個,並將指針移到下一個ֵ
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer currentNext = this.nextElement;
	    if(this.iterator.hasNext() == true)
	        this.nextElement = (Integer)this.iterator.next();
	    else
	        this.nextElement = null;
	    return currentNext;
	}
    
    //判斷是否有下一個ֵ
	@Override
	public boolean hasNext() {
	    if(this.nextElement == null)
	        return false;
	    else 
	        return true;
	}
}