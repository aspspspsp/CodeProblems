package src.LeetCode.Algorithms.Easy;

public class OneBitAndTwoBitCharacters {
    /*
    ?�w??��?��0�M1?�������A�B�X?������?�X�u�঳�T��??�覡�G10�B11�B0�A�P??�w��??�̦Z�@?�����O�_?�_0??(�P�_�̫�@��O�_��0)�A�Ӥ��O10??�C
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
