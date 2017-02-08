package leetcode;

/**
 * Created by ZhengHy on 2017-02-08.
 *
 * 题目：
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    /**
     * 自己的思路，很接近正确思路了，但是不能处理形如 1221 的数组
     * @param nums
     */
    public static void nextPermutation_Self(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }

        //确定要替换的低位
        int tempPositionLow = nums.length - 1;
        int temp;
        int tempSecondPosition  = nums.length - 1;
        //从后往前去比较是否为升序
        for(int i = nums.length - 2 ; i >= 0 ; i --){
            if(nums[tempPositionLow] > nums[i]){
                //在这里交换即可
                temp = nums[tempPositionLow];
                nums[tempPositionLow] = nums[i];
                nums[i] = temp;

                //
                return ;
            }
        }
        //如果来到这里了，则说明需要倒序这个数组
        int left = 0 ;
        int right = nums.length - 1;

        while (left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left ++;
            right --;
        }
        return ;
    }

    /**
     * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为first，后一个记为second，并且满足first 小于 second。然后再从
     * 尾端寻找另一个元素number，如果满足first 小于number，即将第first个元素与number元素对调，并将second元素之后（包括second）
     * 的所有元素颠倒排序，即求出下一个序列
     * example:
     * 6，3，4，9，8，7，1
     * 此时 first ＝ 4，second = 9
     * 从尾巴到前找到第一个大于first的数字，就是7
     * 交换4和7，即上面的swap函数，此时序列变成6，3，7，9，8，4，1
     * 再将second＝9以及以后的序列重新排序，让其从小到大排序，使得整体最小，即reverse一下（因为此时肯定是递减序列）
     * 得到最终的结果：6，3，7，1，4，8，9
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }

        int i= nums.length-1;

        for(;i>=1;i--){

            if(nums[i]>nums[i-1]){ //find first number which is smaller than it's after number
                break;
            }
        }

        if(i!=0){
            swap(nums,i-1); //if the number exist,which means that the nums not like{5,4,3,2,1}
        }

        reverse(nums,i);
    }

    private static void swap(int[] a,int i){
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }

    private static void reverse(int[] a,int i){//reverse the number after the number we have found
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }

    public static void printNums(int[] nums){
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args){
        int a[] = {1,2,2,1};
        printNums(a);
        nextPermutation(a);
        System.out.print("\n");
        printNums(a);
    }
}
