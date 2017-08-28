package LeetCode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;


public class 滑动窗口最大值 {
	public static void main(String[] args) {
		int[] nums={142,38,100,53,22,84,168,50,194,136,111,13,47,45,151,164,126,47,106,124,183,8,87,38,91,121,102,46,82,195,53,18,11,165,61};
		System.out.println(nums.length);
		System.out.println(maxSlidingWindow(nums, 35).toString());
	}
	
	public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (k < 1 || nums.length < k) {
			return result;
		}
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
			while (!queue.isEmpty()&&(nums[i]>nums[queue.getLast()])) {
				queue.pollLast();				
			}
			queue.offerLast(i);//队列中存放的是可能成为最大值的 -- 下标,并不是值
		}
        //队列的最前面存放着当前窗口的最大值
		for (int i = k; i < nums.length; i++) {
			result.add(nums[queue.getFirst()]);
			while (!queue.isEmpty()&&(nums[i]>nums[queue.getLast()])) {
				queue.pollLast();				
			}
			queue.offerLast(i);
			if (i-queue.getFirst()>=k) {
				queue.pollFirst();
			}
		}
		result.add(nums[queue.getFirst()]);
		return result;
	}
}
