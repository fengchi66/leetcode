package demo.dp;

/**
 * 坐标型动态规划
 * dp[i] 表示从起点到坐标 i 的最优值/方案数/可行性
 * dp[i][j] 表示从起点到坐标 i,j 的最优值/方案数/可行性
 */

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
 * 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Solution {

    /**
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     */
    public int countSquares(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0)
            return 0;


        return 0;
    }



}
