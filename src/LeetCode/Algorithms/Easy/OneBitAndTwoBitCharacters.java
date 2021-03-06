package src.LeetCode.Algorithms.Easy;

public class OneBitAndTwoBitCharacters {
    /*
    ?定??中?有0和1?种元素，且出?的元素?合只能有三种??方式：10、11、0，判??定的??最后一?元素是否?于0??(判斷最後一位是否為0)，而不是10??。
    */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1) {
            if(bits[i] == 1)
                i = i + 2;
            else if(bits[i] == 0)
                i = i + 1;
        }

        if(bits.length - 1 == i)
            return true;

        return false;
    }
}
