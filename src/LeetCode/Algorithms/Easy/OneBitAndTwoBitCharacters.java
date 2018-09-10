package src.LeetCode.Algorithms.Easy;

public class OneBitAndTwoBitCharacters {
    /*
    ?﹚??い?Τ0㎝1?销じ?じ?Τ销??よΑ10110??﹚??程?じ琌?0??(耞程琌0)τぃ琌10??
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
