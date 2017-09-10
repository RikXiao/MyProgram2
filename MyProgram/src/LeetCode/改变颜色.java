package LeetCode;

import java.util.Scanner;

public class 改变颜色 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.next();
			char[] arr = input.toCharArray();
			int length = arr.length;
			int[] left = new int[length];
			int[] right = new int[length];
			
			int count = 0;
			for (int i = 0; i < right.length; i++) {
				if (arr[i] == 'G') {
					count++;
				}
				left[i] = count;
			}
			count = 0;
			for (int i = length - 1; i >= 0; i--) {
				if (arr[i] == 'R') {
					count++;
				}
				right[i] = count;
			}
			int min = 1000000;
			for (int i = 0; i < length-1; i++) {
				int tmp = left[i]+right[i+1];
				if (tmp<min) {
					min=tmp;
				}
			}
			if (left[length-1]<min) {
				min=left[length-1];
			}
			System.out.println(min);

		}

	}

}
