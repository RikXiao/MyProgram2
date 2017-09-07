package NiuKe;

import java.util.Arrays;

public class 堆排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,7,6,3,5,7,1,0,36,5,23,12};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapSort(int[] arr){
		if (arr!=null) {
			int len = arr.length;
			for (int i = len/2; i >= 0; i--) {//构造最小堆
				perDown(arr, i, len-1);
			}
			//通过堆排序
			for (int i = len-1; i > 0; i--) {
				swap(arr,0,i);
				perDown(arr, 0, i-1);
			}
			
		}
		
	}
	
	public static void perDown(int arr[],int hole,int end){
		int point = arr[hole];
		int child = 0;
		for (; 2*hole+1<=end; hole=child) {
			child = 2*hole+1;//先等于左节点，然后再和右节点比较；
			if (child!=end&&arr[child+1]<arr[child]) {
				child = child + 1;
			}//找出较小的节点
			//跟当前值比较
			if (point>arr[child]) {
				arr[hole] = arr[child];
			}else {
				break;
			}
		}
		arr[hole] = point;
	}

	public static void swap(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}
