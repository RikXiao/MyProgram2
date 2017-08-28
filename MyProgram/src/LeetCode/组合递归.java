package LeetCode;

import java.util.ArrayList;

public class 组合递归 {

	public static ArrayList<Integer> list = new ArrayList<>();
	public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		int[] A ={1,2,3,4,5};
		System.out.println(combine(A, 3, 4));
		System.out.println(result.toString());
	}
	public static int combine(int[] data,int r,int n){
		if (r>n) {			
			return 0;
		}
		if (r==0) {
			ArrayList<Integer> list1 = new ArrayList<>(list);
			result.add(list1);
			return 1;
		}
		//拿第n个
		list.add(data[n-1]);
		int tmp1 = combine(data, r-1, n-1);
		list.remove(list.size()-1);
		//不拿第n个
		int tmp2 = combine(data, r, n-1);
		return tmp1+tmp2;
		
	}
}
