package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class 最大和 {

	/**
	 * @param args
	 */
	public static int max = -1;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			max = -1;
			int n = in.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
			for (int i = 1; i <= n; i++) {	
				list.clear();
				for (int j = 0; j < i; j++) {
					list.add(in.nextInt());
				}
				lists.add(new ArrayList<>(list));
			}
			getMaxSum(lists, 1, 0, 0, n);
			System.out.println(max);
		}

	}
    // 当前位于第n行，下标为i的数字
	public static void getMaxSum(ArrayList<ArrayList<Integer>> lists,int row,int i,int sum,int n){
		
		if(row>n){
			if (sum>max) {
				max = sum;
			}
		}else {			
			if(i>=0&&i<row){
			    ArrayList<Integer> list = lists.get(row-1);
			    sum+=list.get(i);
			    getMaxSum(lists, row+1, i-1, sum, n);
			    getMaxSum(lists, row+1, i+1, sum, n);
				
			}			
		}
		
	}
}
