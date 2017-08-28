package NiuKe;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;
import javax.security.auth.x500.X500Principal;

public class 最长公共子序列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String xString = "CBDABAe";
        String yString = "ABCABCADe";
        char[] x = xString.toCharArray();
        char[] y = yString.toCharArray();
        int[][] result = new int[x.length][y.length];
        for (int i = 0; i < result.length; i++) {
        	 Arrays.fill(result[i], -1);
		}
       
        System.out.println(maxSeq(x, y, x.length-1, y.length-1,result));
		
	}
	//公共子序列不一定是连续的(动态递归法)
	public static int maxSeq(char[] x,char[] y,int xi,int yi,int[][] result){
		if (xi<0||yi<0) {
			return 0;
		}
		if (result[xi][yi]>=0) {
			return result[xi][yi];
		}
		int tmp = Math.max(maxSeq(x, y, xi-1, yi,result), maxSeq(x, y, xi, yi-1,result));
		if (x[xi]==y[yi]) {
			return result[xi][yi]=Math.max(1+maxSeq(x, y, xi-1, yi-1,result), tmp);
		}else {
			return result[xi][yi]=tmp;
		}
	}
	
/*	public static getMaxSeq(){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
			
				int tmp = Math.max(result[i-1][j],result[i][j-1]);
				if (X[i]==y[j]) {
					result[i][j] = Math.max(1+result[i-1][j-1], tmp);
				}else{
					result[i][j] = tmp;
				}
			}
		}
	}*/

}
