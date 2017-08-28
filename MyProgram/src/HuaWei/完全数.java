package HuaWei;

import java.util.Scanner;

public class 完全数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int count =0;
			for (int i = 1; i <= n; i++) {
				if (isFull(i)) {
					count++;
				}
			}
			System.out.println(count);
		}

	}
	
	public static boolean isFull(int k){
		int sum =0;
		for (int i = 1; i < k; i++) {
			if (k%i==0) {
				sum+=i;
			}
		}
		if (sum==k) {
			return true;
		}else {
			return false;
		}
		
	}

}
