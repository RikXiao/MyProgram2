package NiuKe;

import java.util.ArrayList;
import java.util.Arrays;

public class 吹气球 {

	/**
	 * @param args
	 * dp[i][j] 表示吹爆第i到j获得的最高分
	 * 那么考虑时倒过来考虑，不是以第一个打谁分，而是以最后一个打谁来区分求所有可能最小的一个
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int [] nums={4,1,5,10};
   maxCoins(nums);
   System.out.println(max);
	}
	public static int max =0;
	
	/**
	 * @param args
	 * dp[i][j] 表示吹爆第i到j获得的最高分
	 * 那么考虑时倒过来考虑，不是以第一个打谁分，而是以最后一个打谁来区分求所有可能最小的一个
	 * 有0不能打的，就是在考虑哪一个作为最后一个打时，判断是否为0，若是就不打这个球，就是按midval=0，并且其他数计算时注意左右为0的判断要乘以1
	 */
	public int maxScores(int[] nums){
		int n = nums.length;
		int[][] dp = new int[n+2][n+2];//加2是因为要在首尾各加一个1，这样以避免处理首尾问题
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		int[] arr = new int[n+2];//创建一个新数组存放nums（1到n位），首尾置1；
		arr[0]=1;
		arr[n-1] = 1;
		for (int i = 1; i <= nums.length; i++) {
			arr[i] = nums[i-1];
		}
		return search(arr, dp, 1, n);
	}
	
	public int search(int[] arr,int[][] dp,int left,int right){
		if (dp[left][right]>-1) {
			return dp[left][right];
		}
		
		int res = 0;
		for (int i = left; i <=right; i++) {
			int midval = arr[left-1]*arr[i]*arr[right+1];
			int leftval = search(arr, dp, left, i-1);
			int rightval = search(arr, dp, i+1, right);
			res = Math.max(res, leftval+midval+rightval);
		}
		dp[left][right] = res;
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	 public static int maxCoins(int[] nums) {
		 int legth = nums.length;
		 boolean[] flag = new boolean[legth];
		 ArrayList<Integer> list = new ArrayList<>();
	      max(nums, flag, legth, 0,list);
	      return max;
	 }
	 
	 public static void max(int[] nums,boolean[] flag,int k,int count,ArrayList<Integer> list){
		 if (k==0) {
			if (count>max) {
				max = count;
				System.out.println(max);
				System.out.println(list.toString());
			}
		}else {
			for (int i = 0; i < flag.length; i++) {
				if (flag[i]==false) {
					flag[i] = true;
					int tmp =count;
					
						list.add(nums[i]);
						int left = findLeft(nums,flag,i);
						int right = findRight(nums, flag, i);
						tmp=count+(left*nums[i]*right);						
					
					max(nums, flag, k-1, tmp,list);
					list.remove(list.size()-1);
					flag[i] = false;
				}
			}
		}
	 }
	 public static int findLeft(int[] nums,boolean[] flag,int i){
		 int result =1;
		 for (int j =i-1; j >=0; j--) {
			if(flag[j]==false){
				
					result=nums[j];
				
				break;
			}
		}
		 return result;
	 }
	 public static int findRight(int[] nums,boolean[] flag,int i){
		 int result =1;
		 for (int j =i+1; j<nums.length; j++) {
			if(flag[j]==false){
				
					result=nums[j];
				
				break;
			}
		}
		 return result;
	 }
	 
}
