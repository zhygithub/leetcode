package leetcode;

/**
 * Created by ZhengHy on 2017-01-04.
 *
 * 题目：
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 *
 * 解法：动态规划
 */
public class MinimumPathSum {

    public static  int minPathSum(int[][] grid) {
        for(int i =  1 ; i < grid[0].length ; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i = 1 ; i < grid.length ; i ++){
            grid[i][0] += grid[i-1][0];
            for(int j = 1 ; j < grid[i].length ; j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }

        return grid[grid.length-1][grid[grid.length-1].length-1];
    }

    public static void main(String[] args){
        int[][] array = new  int[][]{
                {1,2,3,4},
                {8,7,8,9},
                {11,2,7,8},
                {6,2,1,1}
        };

        System.out.print(minPathSum(array));
    }

}
