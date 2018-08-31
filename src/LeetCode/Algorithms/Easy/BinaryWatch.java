package src.LeetCode.Algorithms.Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	//先將一個數分成小時與分鐘，然後轉換為1進制，若他們的二進制相加為一個數則顯示他們
    public List<String> readBinaryWatch(int num) {
        List<String> answers = new ArrayList<String>();
        for(int hour = 0; hour < 12; hour ++) {
            for(int minute = 0; minute < 60; minute ++) {
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    String answer = String.format("%d:%02d",hour, minute);
                    answers.add(answer);
                }
            }
        }
        
        return answers;
    }
}