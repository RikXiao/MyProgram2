package HuaWei;

import java.util.Scanner;

public class 放苹果 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			if (m>=1&&m<=10&&n>=1&&n<=10) {
				int count = count(m, n);
				System.out.println(count);
			}else {
				System.out.println(-1);
			}
		}
	}
	
	public static int count(int m,int n){//可以建立一个数组优化
		if (m<0||n<=0) {//苹果个数为负数返回0,或者盘子个数为负数或者0（苹果个数为0是有意义的，其实n每次减1，不可能到0）
			return 0;
		}
		if (m==1||n==1||m==0) {
			return 1;
		}
		return count(m-n, n)+count(m, n-1);
		
		
	}

}
