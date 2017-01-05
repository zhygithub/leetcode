package leetcode;

/**
 * Created by ZhengHy on 2017-01-05.
 *
 *  题目：
 *  1 ) 给定一个 m 乘 n 的二位数组
 *  给出 从 左上角 到 右下角 的所有路径数目总和
 *
 *  2 ) 在这个二位数组中加入了障碍物品，以 1 作为障碍物
 *
 *  解法：动态规划
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return  0;
        }

        int[] array = new int[n];

        for(int i = 0 ; i < n  ; i ++ ){
            array[i] = 1;
        }

        for(int i = 1 ; i < m ; i ++){
            for(int j = 1 ; j < n ; j++){
                array[j] = array[j] + array[j-1];
            }
        }

        return array[n-1];
    }

    public static int uniquePaths2(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }

        if(obstacleGrid[0][0] > 0 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1] > 0){
            return  0;
        }

        obstacleGrid[0][0] = 1;

        for(int i = 1 ; i < obstacleGrid[0].length ; i ++){
            if(obstacleGrid[0][i] > 0){
                obstacleGrid[0][i] = -obstacleGrid[0][i];
            }else if(obstacleGrid[0][i-1] >= 0 ){
                obstacleGrid[0][i] = obstacleGrid[0][i] + obstacleGrid[0][i-1];
            }
        }

        for(int i = 1 ; i < obstacleGrid.length ; i ++){
            if(obstacleGrid[i][0] > 0){
                obstacleGrid[i][0]  = -obstacleGrid[i][0];
            }else if(obstacleGrid[i-1][0] >=0 ){
                obstacleGrid[i][0] = obstacleGrid[i][0] + obstacleGrid[i-1][0];
            }

            for(int j = 1 ; j < obstacleGrid[i].length ; j++){
                if(obstacleGrid[i][j] > 0){
                    obstacleGrid[i][j]  = -obstacleGrid[i][j];
                }else{
                    if(obstacleGrid[i-1][j] >=0 ){
                        obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i-1][j];
                    }

                    if(obstacleGrid[i][j-1] >=0 ){
                        obstacleGrid[i][j] = obstacleGrid[i][j] +obstacleGrid[i][j-1];
                    }

                }
            }
        }

        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1];
    }

    public static void main(String[] args){
        System.out.print(uniquePaths(3,7));
        System.out.print("\n");
        int[][] array = new  int[][]{
                {1}
        };
        System.out.print(uniquePaths2(array));
    }

}
