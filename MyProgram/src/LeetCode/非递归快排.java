package LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 非递归快排 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,6,4,10,6,9,8,32,56,12};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	public static void quickSort(int[] arr,int left,int right){
		if (left<right) {
			Deque<Integer> stack = new LinkedList<>();
			stack.offer(left);//先添加左
			stack.offer(right);//添加右边下标
			while(!stack.isEmpty()){
				 left = stack.poll();
				 right= stack.poll();
				int mid = (left+right)/2;
				int point = arr[mid];
				swap(arr, mid, right);
				int i= left,j = right-1;
				while(i<=j){
					while(arr[i]<point){i++;}
					while(i<j&&arr[j]>point){j--;}
					if (i<j) {
						swap(arr, i++, j--);
					}else {
						break;
					}
				}
				swap(arr, i, right);
				if (left<i-1) {
					stack.offer(left);
					stack.offer(i-1);
				}
				if (i+1<right) {
					stack.offer(i+1);
					stack.offer(right);
				}				
			}						
		}
		
	}
	public static void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	
}
