package Medium;

import java.util.Arrays;

/*
给出一个数组记录一个研究者各篇文章的引用数，写一个函数计算这个研究者的H指数

解题方法
H指数是一个2005年由Jorge E. Hirsch提出的用于评估研究人员的学术产出数量与学术产出水平的指标。
更详细的信息可以参考h-index的维基百科页面。
例如:給定引用數組為=[3,0,6,1,5]，它代表了某個研究員共有五篇論文，而每篇論文的引用數依序為3、0、6、2與5。
自該研究員有三篇論文引用數至少有3次，而剩下兩篇論文引用數則不足3次，故這個研究員的h-index為3。
(即一个人在其所有学术文章中有N篇论文分别被引用了至少N次，他的H指数就是N。)
如美國耶魯大學免疫學家理察·弗來沃發表的900篇文章中，有107篇被引用了107次以上，他的H指數是107。

首先阐述一个事实：
h-index不超过L（即h-index <= L，L是citations数组长度）；
当h-index == L时，citations所有值都不小于L；
*/
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;
        
        //数组元素降序排列
        Arrays.sort(citations);

        //计算H指数
        int result = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(result >= citations[i])
                break;
            result ++;
        }
        return result;
    }
}