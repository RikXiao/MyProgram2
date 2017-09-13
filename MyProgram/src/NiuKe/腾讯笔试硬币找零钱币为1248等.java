package NiuKe;

import java.util.Scanner;

public class 腾讯笔试硬币找零钱币为1248等 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in );
		while(in.hasNext()){
			int n = in.nextInt();
			int k =0;
			for (int i = 0;  Math.pow(2,i)<=n; i++) {
				k=i;
			}
			//result 数组保存结果，result[i][j]表示使用前i种硬币找j快钱所有的方案数
 		    int[][] result = new int[k+2][n+1];
 		    //初始化第一行，使用0中硬币，找钱，方案数位0
			for (int j = 0; j < result.length; j++) {
				result[0][j] = 0;			
			}
			//使用0种硬币找0块钱需要置1；
			result[0][0] = 1;
			
			for (int i = 1; i <= k+1; i++) {
				result[i][0] = 1;//初始化第一列为1
				for (int j =1; j <=n; j++) {
					int money = (int)Math.pow(2, i-1);//第i中硬币的面额
					if (money>j) {//如果面额大于待找的钱j，则不使用该种硬币
						result[i][j] = result[i-1][j];
					}
					if (money<=j&&2*money>j) {//可以使用一个当前硬币时的方案数
						result[i][j] = result[i-1][j]+result[i-1][j-money];
					}
					if (2*money<=j) {		//可以使用两个当前硬币时的方案数				
						result[i][j] = result[i-1][j]+result[i-1][j-money]+result[i-1][j-2*money];
					}
				}
			}
			//最后的方案数
			System.out.println(result[k+1][n]);
		}


}
}