package HuaWei;

import java.util.Scanner;

public class 记负均正 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count1 = 0;
		int count2 =0;
		int sum=0;
		while(in.hasNext()){
			int n = in.nextInt();
			if (n<0) {
				count1++;
			}else {
				count2++;
				sum+=n;
			}
		}
		System.out.println(count1);
		if (count2!=0) {
			float avg = (float)sum/count2;
			System.out.printf("%.1f\n", avg);
		}else {
			System.out.printf("%.1f\n", 0.0);
		}

	}

}
