package leetcode;

/**
 * Created by ZhengHy on 2016-12-12.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int max = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length ; i ++){
            if(max <= nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
