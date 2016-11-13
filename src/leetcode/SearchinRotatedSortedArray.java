package leetcode;

import java.util.ArrayList;

/**
 * Search in Rotated Sorted Array
 * @author Administrator
 *
 */
public class SearchinRotatedSortedArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{
				4,5,6,7,0,1,2,3
		};
		print(array);
		System.out.println(search(array,5));
	}
	
	public static int search(int[] nums, int target){
		int first = 0 ,last = nums.length;
		
		while(first != last){
			int mid = first + (last - first) /2;
			
			if(nums[mid] == target){
				return mid;
			}
			
			if(nums[first] <= nums[mid]){
				if(nums[first] <= target && target < nums[mid]){
					last = mid;
				}else{
					first = mid +1;
				}
			}else{
				if(nums[mid]<target && target <=nums[last-1]){
					first = mid +1;
				}else{
					last = mid;
				}
			}
		}
		return -1;
	}
	
	public static void print(int[] list){
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("\n");
	}

}
