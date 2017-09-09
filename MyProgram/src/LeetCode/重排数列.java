package LeetCode;

import java.util.Scanner;


public class 重排数列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//应该直接全排列的
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int t = in.nextInt();
			for (int i = 0; i < t; i++) {
				int len = in.nextInt();
				long[] arr = new long[len];
				for (int j = 0; j < len; j++) {
					arr[j] = in.nextInt();
				}
				boolean result = false;
				for (int j = 0; j < arr.length; j++) {
					swap(arr, 0, j);
					result = isTrue(arr, 0);
					if (result) {
						break;
					}
					swap(arr, 0, j);
				}
				if(result){
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}						
				
			}
			
		}
		in.close();
	}
	
	public static boolean isTrue(long[] arr,int index){
		if (index == arr.length-1) {
			return true;
		}
		boolean result = false;
		for (int j = index+1; j < arr.length; j++) {
			if ((arr[index]*arr[j])%4==0) {
				swap(arr, index+1, j);
				result = isTrue(arr, index+1);
				if (result) {
					return true;
				}
				swap(arr, index+1, j);								
			}
		}
		return result;
		
	}
	
	
	 public static void swap(long[] num,int i,int j){
	    	long temp= num[i];
	    	num[i] = num[j];
	    	num[j] = temp; 
	    }
}
