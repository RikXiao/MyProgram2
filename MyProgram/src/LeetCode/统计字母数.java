package LeetCode;

import java.util.Scanner;

public class 统计字母数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			char[] arr = str.toCharArray();
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				char ch = arr[i];
				if (ch>='a'&&ch<='z'||ch>='A'&&ch<='Z') {
					count++;
				}else {
					if (ch=='.') {
						System.out.println(count);
					}else {
						System.out.print(count+" ");
						count = 0;
					}
					
				}
			}
		}

	}

}
