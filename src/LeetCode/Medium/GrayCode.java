package src.LeetCode.Medium;
/*
在题目说明中已经说明了“只支持一种格雷码的编码方案”，
因此我们只需要搞清楚出题人希望我们实现的格雷码编码方案的生成规律就可以了。

我们先看几个不同位数的格雷码：
1）n=1时，序列为：0、1
2）n=2时，序列为：00、01、11、10
3）n=3时，序列为：000、001、011、010、110、111、101、100
4）n为任意自然数时，有如下一组规律
以0为开始，每次更改右数数字的位数，可以看做是中根遍历下图这颗二叉树
                    n
                   / \
                 n-1 n-1
                 ... ...
        3       3             3
       / \     / \           / \
      2   2   2   2    ...  2   2
     / \ / \ / \ / \       / \ / \
     1 1 1 1 1 1 1 1       1 1 1 1
我们在实现的算法里并不需要用到树这个概念，这个图只是帮助理解我们算法中的递归。
我们可以用位运算很轻易地获得这些位在二进制上的权（weight），
并使用异或运算实现指定数位中0到1或1到0的转换，每次转换都会生成一个新的格雷码。
先在list中加入所有格雷码都需要添加的数字0，然后考虑生成长度为n的格雷码

生成长度为n的格雷码可以分为下面的步骤：
1.判断n的值，如果是0直接返回，如果是1直接执行第3步立即返回（这一步是递归出口）
2.生成长度为n-1的格雷码，将生成的数字依次插入list（这一步需要递归调用本步骤）
3.让右数第n位数字为1，即将当前数字异或上2的n-1次方，将这个数插入list
4.保证最左侧数字为1，再次生成长度n-1的格雷码，将生成的数字依次插入list
 （这一步需要递归调用本步骤）

需要注意的是，每次生成的格雷码，都会用作下一个格雷码的输入
*/

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    //临时存储当前数字
    int numCur;
    
    //結果
    List<Integer> result;
    public List<Integer> grayCode(int n) {
        if(n < 0) {
            return null;
        }
        
        result = new ArrayList<>();
        //任何格雷碼的第一位數字都是0
        numCur = 0;
        result.add(numCur);
        
        //递归生成格雷码放入arrayList
        getGrayCode(n);
        
        return result;
    }
    
    void getGrayCode(int n) {
    	//�ж�n��ֵ�������0ֱ�ӷ���
        if(n == 0) {
            return;
        }
        
        //�����1ֱ��ִ������t�Y������һ���ǵݹ���ڣ�
        if(n == 1) {
        	//��������nλ����Ϊ1��������ǰ�������1�������������list
            numCur = numCur ^ 1;
            result.add(numCur); 
        } else {
        	//���ɳ���Ϊn-1�ĸ����룬�����ɵ��������β���list����һ����Ҫ�ݹ���ñ����裩
            getGrayCode(n - 1);
            //��������nλ����Ϊ1��������ǰ���������2��n-1�η��������������list
            numCur = numCur ^ (1 << (n - 1));
            result.add(numCur);
            //��֤���������Ϊ1���ٴ����ɳ���n-1�ĸ����룬�����ɵ��������β���list
            //����һ����Ҫ�ݹ���ñ����裩
            getGrayCode(n - 1);
        }
    }
}