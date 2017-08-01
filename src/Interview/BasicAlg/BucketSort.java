package Interview.BasicAlg;
/**
 * 
 * @author zihanxu
 */
/*
 桶排序
	1),已知其区间,例如[1..10],学生的分数[0...100]等
	2),如果有重复的数字,则需要 List<int>数组,这里举的例子没有重复的数字
	若直接用桶排序，會吃數字，需要做改進
	缺點:耗記憶體
	@param unsorted:待排数组
	@param maxNumber:待排数组中的最大数,如果可以提供的话
	
	return 已排序數組

桶排序工作原理
准备10个空桶,最大数个空桶
[6 2 4 1 5 9]           待排数组
[0 0 0 0 0 0 0 0 0 0]   空桶
[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在)

1,顺序从待排数组中取出数字,首先6被取出,然后把6入6号桶,
这个过程类似这样:空桶[ 待排数组[ 0 ] ] = 待排数组[ 0 ]
[6 2 4 1 5 9]           待排数组
[0 0 0 0 0 0 6 0 0 0]   空桶
[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在)

2,顺序从待排数组中取出下一个数字,此时2被取出,将其放入2号桶,是几就放几号桶
[6 2 4 1 5 9]           待排数组
[0 0 2 0 0 0 6 0 0 0]   空桶
[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在)

3,4,5,6省略,过程一样,全部入桶后变成下边这样
[6 2 4 1 5 9]           待排数组
[0 1 2 0 4 5 6 0 0 9]   空桶
[0 1 2 3 4 5 6 7 8 9]   桶编号(实际不存在)

0表示空桶,跳过,顺序取出即可:1 2 4 5 6 9
 */

public class BucketSort {
	public static void main(String[] args) {
        int[] x = { 100, 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        int[] sorted = buckSort(x, 100);
        for (int i = 0; i < sorted.length; i++)
        {
            if (sorted[i] > 0)
                System.err.println(sorted[i]);
        }
		
	}
	
	static int[] buckSort(int[] unsorted, int maxNumber) {
		int[] sorted = new int[maxNumber + 1];
		for(int i = 0; i < unsorted.length; i ++) {
			sorted[unsorted[i]] = unsorted[i];
		}
		
		return sorted;
	}
	
}
