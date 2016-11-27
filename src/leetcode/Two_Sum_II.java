package leetcode;

/**
 * Created by ZhengHy on 2016/11/27 0027.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {

        if(numbers.length<2){
            return new int[0];
        }


        int maxIndex = qSort(numbers,target)+1;

        if(maxIndex >numbers.length -1){
            maxIndex -- ;
        }

        int left = 0,right = maxIndex;

        while(numbers[left]+numbers[right]!=target&&left < right){
            if(numbers[left]+numbers[right] < target){
                left++;
            }else{
                right--;
            }
        }

        int[] array = new int[2];

        array[0] = left+1;
        array[1] = right+1;

        return array;
    }

    public int qSort(int[] numbers ,int target){
        int left = 0, right = numbers.length-1;
        int mid = ( left + right ) / 2;
        while(left < right){
            if(numbers[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
            mid = ( left + right ) / 2;
        }
        return mid;
    }

    public static void main(String[] args){

        Two_Sum_II s = new Two_Sum_II();
        int[] array = new int[]{2,3,4};
        array = s.twoSum(array,6);
        System.out.print(array[0]+" "+array[1]);
    }
}
