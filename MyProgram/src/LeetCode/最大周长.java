package LeetCode;

import java.util.Scanner;


public class 最大周长 {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in 

);
		while (scanner.hasNext()) {
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			int c=scanner.nextInt();
			System.out.println(getMaxZhoucheng(a,b,c));
		}
		scanner.close();
		
		
	}

	private static int getMaxZhoucheng(int a, int b, int c) {
		// TODO Auto-generated method stub
		int max=0;
		for (int i = a; i >=0; i--) {
			for (int j = b; j >=0; j--) {
				for (int k = c; k >=0; k--) {
					if (getSanjiaoxing(i,j,k)) {
						max=i+j+k;
						return max;
					}
				}
			}
		}
		return 0;
	}

	private static boolean getSanjiaoxing(int i, int j, int k) {
		// TODO Auto-generated method stub
		if (i+j>k&&i+k>j&&j+k>i) {
			return true;
		}
		return false;
	}

}

