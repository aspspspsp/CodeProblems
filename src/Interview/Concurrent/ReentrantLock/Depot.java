package Interview.Concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {
	private int capacity; //倉庫的容量
	private int size; //倉庫的實際數量
	private Lock lock; //獨佔鎖
	private Condition fullCondition; //生產條件
	private Condition emptyCondition; //消費條件
	
	public Depot(int capcity) {
		this.capacity = capcity;
		this.size = 0;
		this.lock = new ReentrantLock();
		this.fullCondition = this.lock.newCondition();
		this.emptyCondition = this.lock.newCondition();
	}
	
	public void produce(int val) {
		this.lock.lock();
		try {
			// left表示想要生產的數量(有可能生產量太多，需多此生產)
			int left = val;
			while(left > 0) {
				//庫存已滿時，等待消費者消費產品
				while(this.size >= this.capacity) {
					this.fullCondition.await();
				}
				
				//獲取實際生產的數量(即庫存中新增的數量)
				//如果庫存+想要生產的數量>總的容量，則實際增量=總的容量-當前容量。(此時填滿倉庫)
				//否則實際增量=想要生產的數量
				int inc = (this.size + left) > this.capacity ? (this.capacity - this.size) : left;
				this.size += inc;
				left -= inc;
				
				System.out.printf("%s produce(%d) --> left=%3d inc=%3d size=%3d\n",
						Thread.currentThread().getName(), val, left, inc, this.size);
				//通知消費者可以進行消費了
				this.emptyCondition.signal();
			}
		} catch (InterruptedException e) {
		} finally {
			this.lock.unlock();
		}
	}
	
	public void consume(int val) {
		this.lock.lock();
		try {
			//left表示客戶要消費的數量(有可能消費量太大，庫存不夠，需多此消費)
			int left = val;
			while(left > 0) {
				//庫存為0時，等待生產者生產產品
				while(this.size <= 0) {
					this.emptyCondition.await();
				}
				
				//獲取實際消費的數量(即庫存中實際減少的數量)
				//如果庫存<客戶要消費的數量，則實際消費量=庫存
				//否則，實際消費輛=客戶要消費的數量
				int dec = (this.size < left) ? this.size : left;
				this.size -= dec;
				left -= dec;
				
				System.out.printf("%s consume(%d) <-- left=%3d, dec=%3d, size=%3d\n", 
						Thread.currentThread().getName(), val, left, dec, this.size);
				
				//生產者可以開始生產了
				this.fullCondition.signal();
			}
		} catch (InterruptedException e){	
		} finally {
			lock.unlock();
		}
	}
	
	public String toString() {
		return "capacity:" + this.capacity + ", actual size:" + this.size;
	}
}