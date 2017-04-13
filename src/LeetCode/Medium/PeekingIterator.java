package LeetCode.Medium;

import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator iterator; //������е�ֵ
    Integer nextElement; //�����һ��ֵ
    
    //��ʼ��
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    
	    //ȡ��ݔ������д�ŵ�ֵ��Ȼ����Minterator
	    this.iterator = iterator;
	    
	    if(iterator.hasNext() == true) {
	        this.nextElement = iterator.next();
	    } else {
	        this.nextElement = null;
	    }
	}

    //ȡ����һ��ֵ����ָᘲ��Ƶ���һ��ֵ
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.nextElement;
	}
    
    //ȡ����һ��,�K��ָ��Ƶ���һ��ֵ
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
    
    //�Д��Ƿ�����һ��ֵ
	@Override
	public boolean hasNext() {
	    if(this.nextElement == null)
	        return false;
	    else 
	        return true;
	}
}