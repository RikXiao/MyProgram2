package NiuKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 掷色子组合 {

	/**
	 * @param args
	 */
	public static int count = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int x = in.nextInt();		
			count = 0;
			combine(1, n, 0, x);
			int sum = (int)Math.pow(6, n);
			if (count == 0) {
				System.out.println(0);
			}else if(count==sum) {
				System.out.println(1);
			}else {
				int div = getMaxDivisor(count, sum);
				System.out.println(count/div+"/"+sum/div);
			}
			
		}

	}
	
	public static void combine(int r,int n,int sum,int x){
		if (r>n) {
			if (sum>=x) {
				count++;
			}
			return ;
		}					
		int next = sum;
		for (int i = 1; i <=6; i++) {
			next = sum+i;
			combine(r+1, n, next, x);
		}
		
	}
	public static int getMaxDivisor(int a, int b){
		int left = a%b;
		while(left!=0){			
			a = b;
			b = left;
			left = a%b;
		}
		return b;
	}

}
