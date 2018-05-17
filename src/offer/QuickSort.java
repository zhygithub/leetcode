package offer;

/**
 * Created by ZhengHongyi on 2018/5/13.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] array = {37, 40, 38, 42, 461, 5, 7, 9, 12};
        printArray(array);

        quicksort(array, 0, array.length -1);
        printArray(array);

    }

    public static void quicksort(int[] array, int left ,int right){
        if(array == null || left >= right || left < 0 || right > array.length - 1){
            return;
        }

        int l = left, r = right;
        int sign = 0;
        while(l < r){
           if(sign == 0){
               if(array[r] > array[l]){
                   r --;
               }else{
                   swap(array, r, l);
                   l++;
                   sign = 1;
               }
           }else{
               if(array[l] <= array[r]){
                   l ++;
               }else{
                   swap(array, l, r);
                   r --;
                   sign = 0;
               }
           }
        }

        quicksort(array, left, l - 1);
        quicksort(array, l + 1, right);
    }

    public static void swap(int[] array, int a ,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void printArray(int[] arr){
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

    }
}
