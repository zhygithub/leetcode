package leetcode;

/**
 * Created by ZhengHy on 2016/11/28 0028.
 */
public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
       if(nums == null || nums.length == 0){
           return 0;
       }

       int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int maxEnd = 0 ;
        int minEnd = 0 ;
        for(int i = 1 ; i < nums.length ; i++){
            maxEnd = max * nums[i];
            minEnd = min * nums[i];
            max = Math.max(Math.max(maxEnd,minEnd) ,nums[i]);
            min = Math.min(Math.min(minEnd,maxEnd) ,nums[i]);
            res = Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args){
        int[] array = new int[]{
                2,3
        };
        Maximum_Product_Subarray d = new Maximum_Product_Subarray();
        System.out.print(d.maxProduct(array));
    }
}
