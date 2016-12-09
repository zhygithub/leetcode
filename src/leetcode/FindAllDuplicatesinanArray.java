package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhengHy on 2016/12/7 0007.
 * 题目：找出数组中所有重复两次 的数字，数组红只有出现一次或者两侧的数字，而且1 ≤ a[i] ≤ n (n = size of array),
 *
 * 思路：看下面，很巧妙的思路
 */
public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < nums.length ;i++){
            int index = Math.abs(nums[i] ) - 1;
            if(nums[index] < 0 ){
                list.add(index + 1);
            }
            nums[index] = - nums[index];
        }
        return list;
    }

}
