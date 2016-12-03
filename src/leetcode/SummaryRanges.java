package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhengHy on 2016/12/3 0003.
 */
public class SummaryRanges {

    public static  List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0 ){
            return list;
        }else if(nums.length == 1 ){
            list.add(nums[0]+"");
            return list;
        }

        boolean isTail = false;
        int head = 0 ;
        String str ;

        int i ;
        for ( i = 1 ; i < nums.length; i ++){
            if(nums[i] != nums[i-1] + 1){
                isTail = true ;
            }else {
                isTail = false;
            }

            if(isTail){
                if(i - head > 1 ){
                    str = nums[head] + "->"+nums[(i-1)];
                    list.add(str);
                }else if(i - head == 1){
                    str  =  nums[head] +"";
                    list.add(str);
                }
                head = i ;
            }


        }

        if(i - head > 1 ){
            str = nums[head] + "->"+nums[(i-1)];
            list.add(str);
        }else if(i - head == 1){
            str  =  nums[head] +"";
            list.add(str);
        }
        return list;
    }

    public  static void main(String[] args){
        int[] array = new int[]{
                1,3
        };
        System.out.print(summaryRanges(array).toString());
    }
}
