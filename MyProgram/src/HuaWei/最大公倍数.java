package HuaWei;

import java.util.Scanner;

public class 最大公倍数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 最大公倍数=两个数的积除以最大公约数
		//辗转相除法求最大公约数
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int a = in.nextInt();
			int b = in.nextInt();
			int  maxBeishu = a*b/getMaxDivisor(a, b);
			System.out.println(maxBeishu);
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
