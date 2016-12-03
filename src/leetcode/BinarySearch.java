package leetcode;

/**
 * Created by ZhengHy on 2016/12/1 0001.
 */
public class BinarySearch {

    /**
     * 查找插入的位置
     * @param array
     * @param target
     * @return
     */
    public static int binarySeach(int[] array,int target){
        int left = 0;
        int right  = array.length-1;
        int mid = 0;
        while(left <= right){
            mid = ( left + right ) / 2;
            if(array[mid] == target){
                return mid;
            }

            if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }
        return left;
    }


    public static void main(String[] args){
        int[] array = new int[]{
                1,3,5,6
        };

        System.out.print(binarySeach(array,7));
    }
}
