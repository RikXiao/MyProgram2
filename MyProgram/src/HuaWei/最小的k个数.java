package HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class 最小的k个数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int k = in.nextInt();
			int [] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i]=in.nextInt();
			}
			Arrays.sort(arr);
			for (int i = 0; i < k-1; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println(arr[k-1]);
		}

	}

}
