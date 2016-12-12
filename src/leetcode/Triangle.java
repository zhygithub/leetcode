package leetcode;

import java.util.List;

/**
 * Created by ZhengHy on 2016-12-12.
 */
public class Triangle {

    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     * For example, given the following triangle
     * [
     *    [2],
     *   [3,4],
     *  [6,5,7],
     * [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * 思路:自下而上
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }

        for(int i = triangle.size()-2; i >=0 ; i--){
            List<Integer> list = triangle.get(i);

            int minBottom = 0;

            for(int j = 0 ; j < list.size() ; j ++ ){
                minBottom = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                list.set(j,(list.get(j)+minBottom));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args){

    }
}
