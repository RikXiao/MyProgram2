package HuaWei;

import java.util.Scanner;

public class 动态规划编辑距离 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String stringA = in.nextLine();
			String stringB = in.nextLine();
			int dis = calDistance(stringA, stringB);
			System.out.println(dis);
		}

	}
	
	public static int calDistance(String stringA,String stringB){
		int row = stringA.length();
		int col = stringB.length();
		int[][] dis = new int[row+1][col+1];//动态数组的长度需要加1，因为包括0长度
		for (int i = 0; i <= col; i++) {//初始化第一行和第一列（列和行可能不一样长）
			dis[0][i]=i;
		}
		for (int i = 0; i <= row; i++) {//初始化第一列
			dis[i][0]=i;
		}
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (stringA.charAt(i-1)==stringB.charAt(j-1)) {//注意：这里字符串中第i个字符的下标需要减1
					dis[i][j]=Math.min(dis[i-1][j-1], Math.min(dis[i-1][j], dis[i][j-1])+1);
				}else {
					dis[i][j]=Math.min(dis[i-1][j-1]+1, Math.min(dis[i-1][j], dis[i][j-1])+1);
				}
			}
		}
		return dis[row][col];
	}

}
