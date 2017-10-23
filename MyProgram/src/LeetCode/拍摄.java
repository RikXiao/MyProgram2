package LeetCode;

import java.util.Scanner;

public class 拍摄 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int x0 = in.nextInt();
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if (a<b) {
					arr[i][0] = a;
					arr[i][1] = b;
				}else {
					arr[i][0] = b;
					arr[i][1] = a;
				}				 
			}
			int left = arr[0][0],right = arr[0][1];
			for (int i = 1; i < n; i++) {
				if (left<arr[i][0]) {
					left = arr[i][0];
				}
				if (right>arr[i][1]) {
					right = arr[i][1];
				}
			}
			
			int dis1 = Math.abs(x0-left);
			int dis2 = Math.abs(x0-right);
			if (dis1<dis2) {
				System.out.println(dis1);
			}else {
				System.out.println(dis2);
			}
		}

	}

}
