package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhengHy on 2017-01-04.
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        int begin = 0 ;
        for(int i = 0 ; i <  nums.length ; i ++){

            if(nums[i] == 1){
                continue;
            }

            if(i == 0 || nums[i] != nums[i - 1]){
                begin = 0;
            }

            int size = result.size();

            for(int j = begin ; j < size ; j++){
                ArrayList<Integer> newone = new ArrayList<>(result.get(j));
                newone.add(nums[i]);
                result.add(newone);
            }

            begin = size;
        }
        int[] reArray = new int[result.size()];
        int inedx = 0;
        for(List<Integer> list : result){
            reArray[inedx] = 1;
            if(list.size()<=1){
                continue;
            }
            for (Integer inner : list) {
                reArray[inedx] = reArray[inedx] * inner;
            }
            inedx++;
        }

        int[] array = new int[inedx];
        System.arraycopy(reArray,0,array,0,inedx);
        return  array;
    }
    public static int[] productExceptSelf2(int[] nums) {
        int total = 1;
        int zeroCount = 0;
        for (int a : nums) {
            if(a == 0){
                zeroCount++;
                continue;
            }
            total = total * a;
        }
        int[] result = new int[nums.length];
        if(zeroCount > 1 ){
            return result;
        }
        for(int i = 0 ; i < result.length ; i ++){
            if(nums[i] == 0){
                result[i] = total;
            }else{
                if(zeroCount ==1){
                    result[i] = 0;
                }else{
                    result[i] = total / nums[i];
                }
            }
        }

        return result;
    }


    public static void main(String[] args){
        int[] array = new int[]{4,0,2,2};
        int[] ints = productExceptSelf2(array);

        for (int a :
                ints) {
            System.out.print("a = " + a+"\n");
        }
    }
}
