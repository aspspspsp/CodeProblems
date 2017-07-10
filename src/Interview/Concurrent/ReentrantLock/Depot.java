package Interview.Concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {
	private int capacity; //�}�������
	private int size; //�}��Č��H����
	private Lock lock; //�����i
	private Condition fullCondition; //���a�l��
	private Condition emptyCondition; //���M�l��
	
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
			// left��ʾ��Ҫ���a�Ĕ���(�п������a��̫�࣬�������a)
			int left = val;
			while(left > 0) {
				//����ѝM�r���ȴ����M�����M�aƷ
				while(this.size >= this.capacity) {
					this.fullCondition.await();
				}
				
				//�@ȡ���H���a�Ĕ���(������������Ĕ���)
				//������+��Ҫ���a�Ĕ���>�����������t���H����=��������-��ǰ������(�˕r��M�}��)
				//��t���H����=��Ҫ���a�Ĕ���
				int inc = (this.size + left) > this.capacity ? (this.capacity - this.size) : left;
				this.size += inc;
				left -= inc;
				
				System.out.printf("%s produce(%d) --> left=%3d inc=%3d size=%3d\n",
						Thread.currentThread().getName(), val, left, inc, this.size);
				//֪ͨ���M�߿����M�����M��
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
			//left��ʾ�͑�Ҫ���M�Ĕ���(�п������M��̫�󣬎�治���������M)
			int left = val;
			while(left > 0) {
				//����0�r���ȴ����a�����a�aƷ
				while(this.size <= 0) {
					this.emptyCondition.await();
				}
				
				//�@ȡ���H���M�Ĕ���(������Ќ��H�p�ٵĔ���)
				//������<�͑�Ҫ���M�Ĕ������t���H���M��=���
				//��t�����H���M�v=�͑�Ҫ���M�Ĕ���
				int dec = (this.size < left) ? this.size : left;
				this.size -= dec;
				left -= dec;
				
				System.out.printf("%s consume(%d) <-- left=%3d, dec=%3d, size=%3d\n", 
						Thread.currentThread().getName(), val, left, dec, this.size);
				
				//���a�߿����_ʼ���a��
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