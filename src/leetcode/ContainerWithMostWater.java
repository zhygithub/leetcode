package leetcode;

/**
 * Created by ZhengHy on 2017-01-13.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int result  = 0;
        int end ;
        for(int i = 0 ; i < height.length ; i ++){
            end = i;
            for(int j = 0 ; j < end ; j ++){
                if(height[end] < height[j]){
                    int sum =  height[end] * (end - j);
                    if(result < sum){
                        result = sum;
                    }
                }
            }
        }

        return result;
    }


    /**
     * 思路：
     * 1.最左端和最右端个一个指针
     * 2.取两个指针之间的最小高度作为高度，短板原理，求出面积
     * 3.对比保存的最大面积并且更新
     * 4.将指向最小高度的指针想中间逼近，期求更长的高度
     * 5.重复2 - 4
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args){
        int a[] = new int[]{
          1,4,2,7,8,3,6
        };
        System.out.print(maxArea(a));
    }
}
