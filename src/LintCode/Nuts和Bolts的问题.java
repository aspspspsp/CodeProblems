package LintCode;

import LeetCode.Dependencies.NBComparator;

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Nuts和Bolts的问题 {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        for(int i = 0; i < nuts.length; i ++) {
            for(int j = i; j < bolts.length; j ++) {
                int record = compare.cmp(nuts[i], bolts[j]);
                if(record == 0) {
                    swap(bolts, j , i);
                    break;
                }
            }
        }
        
    }
    
    public void swap(String[] bolts, int start, int end) {
        String temp = bolts[start];
        bolts[start] = bolts[end];
        bolts[end] = temp;
    }
}