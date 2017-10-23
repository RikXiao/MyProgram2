package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 求和的组合数 {

	/**
	 * @param args
	 */
	public  static int a =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in = new Scanner(System.in);
      while(in.hasNext()){
    	  int n = in.nextInt();
    	  int m = in.nextInt();
    	  int[][] result = new int[n+1][m+1];
    	  for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], -1);
		}
    	  System.out.println(count(n, m,result));
      }
      in.close();
	}
	
	public  static int count(int n,int m,int[][] result){
		if ((n<1)||m<0) {
			return 0;
		}
		if (m<=2&&n>=m) {			
			return 1;
		}
		if (result[n][m]!=-1) {
			return result[n][m];
		}
		
		result[n][m] = count(n-1, m-n,result)+count(n-1, m,result);
	    return result[n][m];
	}

}
