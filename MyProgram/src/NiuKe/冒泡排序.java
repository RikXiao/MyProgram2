package NiuKe;

import java.util.Arrays;

public class 冒泡排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6,5,2,3,8,9,7};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		if (arr!=null) {
			int len = arr.length;
			for (int i = len-1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j]>arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
		}
	}

}
