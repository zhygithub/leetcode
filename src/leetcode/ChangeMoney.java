package leetcode;

/**
 * Created by ZhengHy on 2016/12/4 0004.
 * 题目是
 * 给定一个代表了纸币面额的数组，该数组中的面额对应的纸币数量无上限
 * 求给出一个指定数额的值能用最少的纸币数量凑足
 *
 * 思路：动态规划来做
 *
 */
public class ChangeMoney {

    public static int minCoins(int[] arr, int aim){

        if(arr == null || arr.length == 0 || aim == 0){
            return  -1;
        }

        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];

        for(int j = 1; j <= aim; j ++){
            dp[0][j] = max;
            if(j >= arr[0] && dp[0][j-arr[0]] != max ){
                dp[0][j] = dp[0][j-arr[0]] +1;
            }
        }

        int left = max;

        for(int i = 1 ; i < n ; i ++){
            for(int j = 1 ; j <= aim ; j ++){
                left = max;
                if(j >= arr[i] && dp[i][j-arr[i]] != max ){
                    left = dp[i][j-arr[i]] +1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] == max? -1 : dp[n-1][aim];
    }

    private static void printArray(int[][] dp) {

        for (int i = 0 ; i < dp.length ; i ++ ){
            for (int j = 0 ; j < dp[i].length ; j ++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{
                5,2,3
        };
        System.out.print(minCoins(arr,11));
    }
}
