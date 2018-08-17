/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    /*
        我們可以得到一個通用式子來產生 randX() to randY()
        int x_ = 0;
        do {
            x_ = (randX() - 1) * X + randX();
        } while(x_ > Yn);
        // Yn 為Y最大可達的範圍 ex rand7() 縮放後的範圍1~49 那要將 Yn設置到40(10*4)，因為1~10 21~30 31~40 都是等概率
        return x_ % Y + 1;
        
    */
    public int rand10() {
        int res = 0;
        
        do {
            res = (rand7() - 1) * 7 + rand7();
        } while(res > 40);
        
        return res % 10 + 1;
    }
}
