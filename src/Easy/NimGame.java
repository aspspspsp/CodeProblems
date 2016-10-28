/*
 * 尼姆游戏（英语：Nim），又译为拈，是一种两个人玩的回合制数学战略游戏。
 * 游戏者轮流从一堆棋子（或者任何道具）中取走一个或者多个(此題可取走1~3個)，最后不能再取的就是输家。
 * 当指定相应数量时，一堆这样的棋子称作一个尼姆堆。
 */
package Easy;

public class NimGame {
	public boolean canWinNim(int n) {
		//無法取走最後一個
		if(n % 4 == 0)
			return false;
		//可以取走最後一個
		else 
			return true;
	}
}
