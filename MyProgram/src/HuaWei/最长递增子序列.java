package HuaWei;

import java.util.Scanner;

public class 最长递增子序列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int len = in.nextInt();
			int[] arr = new int[len];

			for (int i = 0; i < len; i++) {
				arr[i]=in.nextInt();				
			}			
			int result = getMaxB(arr);
			System.out.println(result);
		}
	}
	
	public static int getMaxB(int[] arr){
		int length = arr.length;
		if (length<=0) {
			return 0;
		}
		int[] results = new int[length];
		results[0]=1;
		
		for (int i = 1; i <length; i++) {
			int max =0;
			for (int j = 0; j < i; j++) {
				if (arr[j]<arr[i]) {
					if (results[j]>max) {
						max=results[j];
					}
				}
			}
			results[i]=max+1;
		}
		//求最大的
		int result =0;
		for (int i = 0; i < length; i++) {			
			if (results[i]>result) {
				result=results[i];
				
			}
		}
		return result;
		
	}

}
