/*
 * 拿石頭遊戲規則，桌上有石頭n個，兩個玩家，你先玩，每次每個玩家可以拿走1~3個石頭，拿走會後一顆石頭的人獲勝，根據以上規則與初始的石頭數量，判斷你是否能贏得這個拿石頭遊戲。
 * 例如說，如果桌上有三顆石頭，你一次全拿，獲勝。
 * 如果桌上有4顆石頭(包含4的倍數)，不管你拿走幾顆，你的對手都會獲勝。
 */
package LeetCode.Easy;

public class NimGame {
	public boolean canWinNim(int n) {
		// 若n為4的倍數，你的對手就會贏
		if(n % 4 == 0)
			return false;
		// 若n不是4的倍數，你就會贏
		else 
			return true;
	}
}
