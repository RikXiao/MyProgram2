package NiuKe;

import java.util.Arrays;

public class 归并排序 {

	
	public static void main(String[] args) {
		int arr[] = {6,6};
		int[] tmp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, tmp);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int left,int right,int[] tmp){
		if (left<right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid,tmp);
			mergeSort(arr, mid+1, right, tmp);
			merge(arr,left,mid,right,tmp);
		}
		
	}
	
	public static void merge(int[] arr,int left,int mid ,int right,int tmp[]){
		int index = left;
		int i = left,j = mid+1;
		while(i<=mid&&j<=right){
			if (arr[i]<arr[j]) {
				tmp[index++] = arr[i++];
			}else {
				tmp[index++] = arr[j++];
			}
		}
		//剩余的加进来
		while(i<=mid){
			tmp[index++] = arr[i++];
		}
		while (j<=right) {
			tmp[index++] = arr[j++];			
		}
		//排序完成后加入原数组
		for (int k = left; k <= right; k++) {
			arr[k] = tmp[k];
		}
	}
}
