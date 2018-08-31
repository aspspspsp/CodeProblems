package src.LeetCode.Algorithms.Hard;

public class DungeonGame {
	//從最後一格(右下角)開始到第0格(左上角)結束
	public int calculateMinimumHP(int [][] dungeon) {
		//處理地牢地圖為空的情況
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 0;
		
		int m = dungeon.length;
		int n = dungeon[0].length;
		//記錄最小血量
		int [][] result = new int[m][n];
		
		//求最後一格(公主那一個開始)所需的血量
		//也就是從最後一格開始求
		result[m - 1][n - 1] = Math.max(1,  1 - dungeon[m - 1][n - 1]);
		
		//填滿最右邊的列
		for(int i = m - 2; i >= 0; i --) {
			int upHp = result[i + 1][n - 1] - dungeon[i][n - 1]; //所需血量
			
			//與上面的格子比較，
			//若所需血量為負數(有加血)則所需血量為1(英雄的最小血量為1)
			result[i][n - 1] = Math.max(1, upHp);
		}
		
		//填滿最下邊的行
		for(int j = n - 2; j >= 0; j --) {
			int leftHp = result[m - 1][j + 1] - dungeon[m - 1][j]; //所需血量
			
			//與左邊的格子比較，
			//若所需血量為負數(有加血)則所需血量為1(英雄的最小血量為1)
			result[m - 1][j] = Math.max(1, leftHp);
		}
		
		//逐漸填滿除最右及最下的其他result格子
		for(int i = m - 2; i >= 0; i --) {
			for(int j = n - 2; j >= 0; j --) {
				int leftHp = result[i + 1][j] - dungeon[i][j];
				int upHp = result[i][j + 1] - dungeon[i][j];
				//從左與上兩個所需血量取最小
				int minHp = Math.min(leftHp, upHp);
				
				//若所需血量為負數(有加血)則所需血量為1(英雄的最小血量為1)
				result[i][j] = Math.max(1, minHp);
			}
		}
		
		//返回第0格即為結果
		return result[0][0];
	}
}
