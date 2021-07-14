package code.class21;

public class Code01_MinPathSum {

    // 动态规划方法：dp[i][j]表示从左上角出发到[i,j]位置的最小路径和
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;

        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];

        // 填表的第一行以及第一列
        for (int i = 1; i < row; i++)
            dp[i][0] = dp[i -1][0] + m[i][0];

        for (int j = 1; j < col; j++)
            dp[0][j] = dp[0][j-1] + m[0][j];

        // 填dp表的其他位置
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;

        int row = m.length;
        int col = m[0].length;

        return process(m, row -1, col -1);
    }

    // 递归：表示从左上角出发到[i,j]位置的最小路径和
    public static int process(int[][] m, int i, int j) {
        if (i == j && i == 0) // base case
            return m[0][0];

        // 往下面走
        int p1 = process(m, j-1,i) + m[i][j];
        int p2 = process(m, j,i-1) + m[i][j];

        return Math.max(p1,p2);
    }


    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 100);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int rowSize = 10;
        int colSize = 10;
        int[][] m = generateRandomMatrix(rowSize, colSize);
        System.out.println(minPathSum(m));
        System.out.println(minPathSum1(m));


    }
}
