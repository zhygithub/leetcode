package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

    private HashSet<String> mHashSet;

    private int[] mSign;

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> mList = new ArrayList<>();
        mHashSet = new HashSet<>();
        mSign = new int[nums.length];
        deep(nums,0);
        mList.clear();
        for (String str:mHashSet){
            String[] split = str.split("[:]");
            List<Integer> list = new ArrayList<>();
            if(split != null){
                for(int i = 0 ; i < split.length ; i++){
                    if(split[i] != null && split[i].length()>=1){
                        list.add(Integer.parseInt(split[i]));
                    }
                }
                mList.add(list);
            }
        }
        return mList;
    }

    public void deep(int[] nums ,int step){

        if(step > nums.length){
            return ;
        }
        List<Integer>  list = new ArrayList<>();
        StringBuilder target  = new StringBuilder();
        for(int i = 0 ; i < nums.length ; i ++){
            if(mSign[i] == 1){
                list.add(nums[i]);
                target = target.append(nums[i]+":");
            }
        }
        mHashSet.add(target.toString());
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

    /**
     * 巧妙的思路
     * 接着 subsets2 方法的思路
     * 在去重方面则是去避免第二个相同的数字去跟第一个相同的数字去做重复的步骤
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsT2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                begin = 0;
            }
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }

    public  static void main(String[] args){
        Subsets subsets = new Subsets();
        int[] array = new int[]{1,2,2};
        System.out.print(subsets.subsetsT2(array).toString());
    }
}
