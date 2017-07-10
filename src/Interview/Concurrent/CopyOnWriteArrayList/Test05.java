package Interview.Concurrent.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test05 {
	/*
	 * CopyOnWriteArrayList通过增加写时复制语义
	 * 来避免并发访问引起的问题，也就是说任何修改
	 * 操作都会在底层创建一个列表的副本，也就意味
	 * 着之前已有的迭代器不会碰到意料之外的修改。
	 * 这种方式对于不要严格读写同步的场景非常有用
	 * ，因为它提供了更好的性能。记住，要尽量减少
	 * 锁的使用，因为那势必带来性能的下降（对数据
	 * 库中数据的并发访问不也是如此吗？如果可以的
	 * 话就应该放弃悲观锁而使用乐观锁），
	 * CopyOnWriteArrayList很明显也是通过牺牲空
	 * 间获得了时间（在计算机的世界里，时间和空间
	 * 通常是不可调和的矛盾，可以牺牲空间来提升效
	 * 率获得时间，当然也可以通过牺牲时间来减少对
	 * 空间的使用）。
	 */
	private static final int THREAD_POOL_SIZE = 2;
	
	public static void main(String[] args) {
		List<Double> list = new CopyOnWriteArrayList<>();
		ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		es.execute(new AddThread(list));
		es.execute(new AddThread(list));
		es.shutdown();
	}
}
