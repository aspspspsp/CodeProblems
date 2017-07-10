package Interview.Concurrent.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test05 {
	/*
	 * CopyOnWriteArrayListͨ������дʱ��������
	 * �����Ⲣ��������������⣬Ҳ����˵�κ��޸�
	 * ���������ڵײ㴴��һ���б�ĸ�����Ҳ����ζ
	 * ��֮ǰ���еĵ�����������������֮����޸ġ�
	 * ���ַ�ʽ���ڲ�Ҫ�ϸ��дͬ���ĳ����ǳ�����
	 * ����Ϊ���ṩ�˸��õ����ܡ���ס��Ҫ��������
	 * ����ʹ�ã���Ϊ���Ʊش������ܵ��½���������
	 * �������ݵĲ������ʲ�Ҳ�������������Ե�
	 * ����Ӧ�÷�����������ʹ���ֹ�������
	 * CopyOnWriteArrayList������Ҳ��ͨ��������
	 * ������ʱ�䣨�ڼ�����������ʱ��Ϳռ�
	 * ͨ���ǲ��ɵ��͵�ì�ܣ����������ռ�������Ч
	 * �ʻ��ʱ�䣬��ȻҲ����ͨ������ʱ�������ٶ�
	 * �ռ��ʹ�ã���
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
