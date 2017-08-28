package HuaWei;

import java.util.Scanner;

public class 单向链表倒数第K个节点 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int length = in.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			int k = in.nextInt();
			if (k>0&&k<=length) {
				System.out.println(arr[length-k]);
			}
			
		}

	}

}
