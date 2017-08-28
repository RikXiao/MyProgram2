package LeetCode;

import java.util.ArrayList;

public class 组合问题 {
	public static void main(String[] args) {
		int[] A ={1,2,3};
		
		System.out.println(kSumII(A, 2, 0).toString());
	}
	
	
	public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
		
        if (A==null||A.length==0) {
			return null;
		}
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        combine(A, A.length-1, k, list, result,target);
        return result;
    }
	public static void combine(int[] A,int n,int m,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result,int target){
		for (int i = n; i >=m-1; i--) {
			list.add(A[i]);
			if (m>1) {
				combine(A, i-1, m-1, list, result,target);		//注意这里是i-1,m也要减1		
			}else {
				int count =0;
				for (int j = 0; j < list.size(); j++) {
					count+=list.get(j);
				}
				if (count==target) {
					result.add(new ArrayList<Integer>(list));
				}				
			}
			list.remove(list.size()-1);
		}
	}
}
