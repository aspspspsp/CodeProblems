package src.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0)
            return 0;
        
        int score;
        List<Integer> scores = new ArrayList<>();
        for(String op : ops) {
            switch(op) {
                //目前分數是將以往的最後兩個分數相加
                case "+":
                    if(scores.size() > 1) {
                        score = scores.get(scores.size() - 1)
                            + scores.get(scores.size() - 2);
                        scores.add(score);
                    }
                    break;
                //刪除以往的最後一個分數
                case "C":
                    if(scores.size() > 0)
                        scores.remove(scores.size() - 1);
                    break;
                //目前分數是將以往的最後一個分數double
                case "D":
                    score = scores.get(scores.size() - 1) * 2;
                    scores.add(score);
                    break;
                //添加分數至分數List
                default:
                    score = Integer.parseInt(op);
                    scores.add(score);
                    break;
            }
        }
        
        int result = 0;
        if(scores == null || scores.size() == 0)
            return result;
        
        for(int s : scores) {
            result += s;
        }
        
        return result;
    }
}