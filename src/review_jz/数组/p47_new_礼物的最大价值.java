package review_jz.数组;

/**
 * @author LiXiwen
 * @date 2020/1/29 10:55
 */
public class p47_new_礼物的最大价值 {
    public static void main(String[] args) {

    }

    public static int getMaxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }

}
/*
在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。

你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。

给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？

 */