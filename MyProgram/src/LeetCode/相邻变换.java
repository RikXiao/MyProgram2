package LeetCode;

import java.util.Scanner;

public class 相邻变换 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			String[] arr = str.split("\\s+");
			for (int i = 1; i <arr.length; i+=2) {
				String s = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = s;
			}
			int len = arr.length;
			for (int i = 0; i < len; i++) {
				if (i!=len-1) {
					System.out.print(arr[i]+" ");
				}else {
					System.out.println(arr[i]+"");
				}
			}
		}

	}

}
