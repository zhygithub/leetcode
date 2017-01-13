package leetcode;

import java.util.Arrays;

/**
 * Created by ZhengHy on 2017-01-08.
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int mid = 0 ;
        while(left <= right){
            mid = (left + right) / 2;

            if(nums[mid] == mid ){
                if(mid + 1 >= nums.length){
                    return mid + 1;
                }
                if(nums[mid + 1] > mid + 1){
                    return mid + 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] > mid){
                if(mid-1 < 0){
                    return 0;
                }

                if(nums[mid-1] == mid-1){
                    return mid ;
                }else{
                    right = mid -1;
                }
            }

        }
        return -1;
    }

    public static  int missingNumber_Better(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static void main(String[] args){
        int[] a = new int[]{1,1,2,3};
        System.out.print(missingNumber(a));
    }
}
