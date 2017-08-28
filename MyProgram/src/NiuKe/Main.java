package NiuKe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String index = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(index.substring(1,2));
		String aString = "89abc";
		System.out.println(Integer.valueOf(aString, 16));
		/*while(in.hasNext()){
			int size  = in.nextInt();
			ArrayList<Integer> scores = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				scores.add(in.nextInt());
			}
			ArrayList<Integer> list = new ArrayList<>();
			getTotal(scores, size, list);
			int count=0;
			for (int i = 0; i < list.size(); i++) {
				count+=list.get(i);
			}
			System.out.println(count);
		}*/
		
		
	}
	
	public static void getTotal(ArrayList<Integer> scores,int size,ArrayList<Integer> list){
		if (size==1) {
			if (scores.get(0)!=0) {
				list.add(scores.get(0));
			}else {
				list.add(0);
			}
		}else {
			int mid = scores.get(0);
			int right = scores.get(1);
			if (right!=0) {
				list.add(mid*right);
			}else {
				list.add(mid);
			}
			scores.remove(0);
			getTotal(scores, size-1, list);
		}
		
	}
	public int maxCoins(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}

}
