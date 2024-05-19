package msb_algorithm.algorithem;

public class App_20240411 {
    int stock = 1, plane = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;

        boolean isStacked = false;

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == stock) {
                isStacked = true;
            }
            if(isStacked) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == stock) {
                isStacked = true;
            }
            if(isStacked) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for(int i = 1;i < row; i++) {
            for(int j = 1;j < col;j++) {
                if(obstacleGrid[i][j] == stock) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] +dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
