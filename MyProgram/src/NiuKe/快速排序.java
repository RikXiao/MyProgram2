package NiuKe;

import java.util.Arrays;

public class 快速排序 {

	
	public static void main(String[] args) {
		int[] arr = {2,2};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void quickSort(int[] arr,int left, int right){
		
		if (left<right) {
			int mid = (left+right)/2;
			int point = arr[mid];
			swap(arr, mid, right);//将枢纽元放到最后面
			int i = left;
			int j = right-1;
			while(i<=j){//加等号处理两个元素的排序
				while(arr[i]<point){i++;}//这里比较不加等号是为了防止出现两个不均衡的数组，导师时间复杂度增加
				while(j>i&&arr[j]>point){j--;}//这里前面的j>i是防止没有比枢纽元小的数时，下标小于left;
				if (i<j) {
					swap(arr, i++, j--);//先使用i,j，然后对i,j进行增减	（防止等于枢纽元时，停止不前）				
				}else {
					break;
				}
			}
			swap(arr, i, right);
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		}
	}
	
	public static void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	
	public static void out(int i){
		System.out.println(i);
	}
}
