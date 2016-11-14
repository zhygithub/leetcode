package leetcode;

import java.util.ArrayList;

/**
 * Search in Rotated Sorted Array2
 * @author Administrator
 *
 */
public class SearchinRotatedSortedArray2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{
			1,3,1,1,1
		};
		print(array);
		System.out.println(search(array,3));
	}
	
	public static boolean search(int[] nums, int target){
		int first = 0 ,last = nums.length;
		
		while(first != last){
			int mid = first + (last - first) /2;
			
			if(nums[mid] == target){
				return true;
			}
			
			if(nums[first] < nums[mid]){
				if(nums[first] <= target && target < nums[mid]){
					last = mid;
				}else{
					first = mid +1;
				}
			}else if(nums[first] > nums[mid]){
				if(nums[mid]<target && target <=nums[last-1]){
					first = mid +1;
				}else{
					last = mid;
				}
			}else{
				first++;
			}
		}
		return false;
	}
	
	public static void print(int[] list){
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("\n");
	}

}
