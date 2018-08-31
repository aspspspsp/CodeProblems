package src.LeetCode.Algorithms.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
解决办法:

思路
初看没有办法下手，其实是一个递归的求解过程。
这么来想，看看现在场上有几个球，然后拿手上的球去配，看看是否够满足消除条件，
在消除掉几个球后，场上剩余的球及手中的球，还是一个递归的子问题。

递推公式
F(n) = F(n-1) + 消费的球个数

终止条件
场上没有球了，都消除掉了，返回成功
场上还有球，但是手里没有球了，返回失败
 */
public class ZumaGame {
    public int findMinStep(String board, String hand) {
        List<Character> boards = new ArrayList<>();
        for(char c : board.toCharArray()) {
            boards.add(c);
        }
        
        Map<Character, Integer> hands = new HashMap<>();
        hands.put('R', 0);
        hands.put('Y', 0);
        hands.put('B', 0);
        hands.put('G', 0);
        hands.put('W', 0);
        for(char h : hand.toCharArray()) {
            hands.put(h, hands.get(h) + 1);
        }
        
        return find(boards, hands);
    }
    
    int find(List<Character> boards, Map<Character, Integer> hands) {
        clearBoard(boards);
        if(boards.size() <= 0) {
            return 0;
        }
        
        if(isEmpty(hands) == true) {
            return -1;
        }
        
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < boards.size(); i ++) {
            Character c = boards.get(i);
            count ++;
            if(i >= boards.size() - 1 || boards.get(i + 1) != c) {
                int need = 3 - count;
                if(hands.get(c) >= need) {
                    List<Character> small = new ArrayList<>(boards);
                    for(int j = 0; j < count; j ++) {
                        small.remove(i - j);
                    }
                    
                    hands.put(c, hands.get(c) - need);
                    int smallerFind = find(small, hands);
                    if(smallerFind > -1) {
                        min = Math.min(min, smallerFind + need);
                    }
                    
                    hands.put(c, hands.get(c) + need);
                }
                count = 0;
            }
        }
        
        if(min == Integer.MAX_VALUE)
            return -1;
        
        return min;
    }
    
    void clearBoard(List<Character> boards) {
        int count = 0;
        boolean cleaned = false;
        
        for(int i = 0; i < boards.size(); i ++) {
            char c = boards.get(i);
            count ++;
            if(i == boards.size() - 1 || boards.get(i + 1) != c) {
                if(count >= 3) {
                    for(int j = 0; j < count; j ++) {
                        boards.remove(i - j);
                    }
                    cleaned = true;
                    break;
                }
                count = 0;
            }
        }
        
        if(cleaned == true) {
            clearBoard(boards);
        }
    }
    
    boolean isEmpty(Map<Character, Integer> hands) {
        for(int val : hands.values()) {
            if(val > 0)
                return false;
        }
        
        return true;
    }
}