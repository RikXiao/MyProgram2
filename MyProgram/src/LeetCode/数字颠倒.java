package LeetCode;

import java.util.Scanner;

public class 数字颠倒 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String n = in.next();
			char[] arr = n.toCharArray();
			for (int i = 0,j = arr.length-1; i <j; i++,j--) {
				char tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			String n2 = String.valueOf(arr);
			int data = Integer.valueOf(n2)+Integer.valueOf(n);
			System.out.println(data);
		}

	}

}
