package NiuKe;

import java.util.Scanner;

public class 罪犯转移 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int length = in.nextInt();
			int max = in.nextInt();
			int num = in.nextInt();
			int[] data= new int[length];
			for (int i = 0; i < data.length; i++) {
				data[i] = in.nextInt();
			}
			int sum =0;
			int result =0;
			for (int i = 0; i < num; i++) {
				sum+=data[i];
			}
			if (sum<=max) {
				result++;
			}
			for (int i = 1; i <= length-num; i++) {
				sum = sum-data[i-1]+data[i+num-1];
				if (sum<=max) {
					result++;
				}
			}
			
			System.out.println(result);
		}

	}

}
