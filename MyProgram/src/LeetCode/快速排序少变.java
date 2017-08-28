package LeetCode;

import java.util.Arrays;

public class 快速排序少变 {
	public static void main(String[] args) {
		int[] arr = {3,2,5,4,1,6,8,7,9,6};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left,int right){
		if (left<right) {
			int midIndex = (left+right)/2;//选取中间元素枢纽元的下标
			swap(arr, midIndex, right);
			int middle = arr[right];//枢纽元
			int small=left;
			
		    for (int i = left; i < right; i++) {
				if (arr[i]<middle) {
					swap(arr, i, small);
					small++;
				}
			}
			swap(arr, small, right);
			quickSort(arr, left, small-1);
			quickSort(arr, small+1, right);
		}
	}
/*	public static void quickSort(int[] arr,int left,int right){
		if (left<right) {
			int midIndex = (left+right)/2;//选取中间元素枢纽元的下标
			swap(arr, midIndex, right);
			int middle = arr[right];//枢纽元
			int i=left;
			int j = right-1;
			while(i<j){
				while(arr[i]<middle&&i<right){i++;}
				while(arr[j]>middle&&j>left){j--;}
				if (i<j) {
					swap(arr, i, j);
				}else {
					break;
				}
			}
			swap(arr, i, right);
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		}
	}*/
	public static void swap(int[] arr ,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
