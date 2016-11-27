package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
	 static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		static int[] sign = new int[9];
		static List<List<Integer>> outter = new ArrayList<>();
		static List<Integer> inner = new ArrayList<>();
		static int counts;
		static int dst;
		
		public static void dfs(int step){
			int i=0;
			if(step == counts){
				int sum = 0 ;
				int min = -1;
				for(int j =0;j<inner.size();j++){
					if(inner.get(j)<min){
						return ;
					}
					min = inner.get(j);
					sum+=inner.get(j);
				}
				if(sum==dst){
					List<Integer> newone = new ArrayList<>(); 
					for (Integer integer : inner) {
						newone.add(integer);
					}
					outter.add(newone);
				}
				return ;
			}
			
			for(i=0;i<9;i++){
				if(sign[i]==0){
					Integer integer = new Integer(array[i]);
					inner.add(integer);
					sign[i]=1;
					
					dfs(step+1);
					
					inner.remove(integer);
					sign[i]=0;
					
				}
			}
			
			return ;
		}
		
	    public List<List<Integer>> combinationSum3(int k, int n) {
	       counts = k;
			dst = n;
			dfs(0);
	        return outter;
	    }

	public static void main(String[] args) {
		Combination_Sum_III s = new Combination_Sum_III();
		System.out.println(s.combinationSum3(3,2));;
	}

}
