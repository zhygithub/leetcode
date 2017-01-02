package leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhengHy on 2016-12-29.
 * Given a set of distinct integers, nums, return all possible subsets.
 * For example,
 * If nums = [1,2,3], a solution is
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * 深度遍历
 */
public class Subsets {

    private List<List<Integer>> mList;

    private int[] mSign;

    public List<List<Integer>> subsets(int[] nums) {
        mList = new ArrayList<>();
        mSign = new int[nums.length];
        deep(nums,0);
        return mList;
    }

    public void deep(int[] nums ,int step){

        if(step > nums.length){
            return ;
        }
        List<Integer>  list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(mSign[i] == 1){
                list.add(nums[i]);
            }
        }
        mList.add(list);
        for(int i = step ; i < nums.length ; i++){
            mSign[i] = 1;
            deep(nums,i+1);
            mSign[i] = 0;
        }
    }

    /**
     * f(x) = f(x-1) + d
     * 利用上一步算得的结果拼接多一个参数
     *  如 输入 1，2，3
     *  拼接过程
     *  1                                  总的list： 1
     *  2 ，12                             总的list： 1 ，2 ，12
     *  3 ，13，23，123                    总的list： 1 ，2 ，12 ，3，13，23，123
     *  
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(nums);
        for(int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;

    }

    public  static void main(String[] args){
        Subsets subsets = new Subsets();
        int[] array = new int[]{1,2,3};
        System.out.print(subsets.subsets2(array).toString());
    }
}
