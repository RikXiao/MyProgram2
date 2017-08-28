package HuaWei;

import java.util.Scanner;

public class 数独 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int[][] sudu = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudu[i][j] = in.nextInt();
				}
			}
			if (fillSudu(sudu, 0)) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (j==8) {
							System.out.println(sudu[i][j]);
						}else {
							System.out.print(sudu[i][j]+" ");
						}
						
					}
				}
			}else {
				System.out.println("错误");
			}
			
		}

	}

	public static boolean fillSudu(int[][] sudu,int n){		
		if (n<81) {
			int row = n/9;
			int col = n%9;
			if (sudu[row][col]==0) {
				for (int i = 1; i <= 9; i++) {
					if (isFit(sudu, i, row, col)) {
						sudu[row][col]=i;
						if (fillSudu(sudu, n+1)) {
							return true;
						}
						sudu[row][col]=0;
					}
				}
				return false;
				
			}else {
				return fillSudu(sudu, n+1);
			}
		}else {
			return true;
		}		
	}
	public static boolean isFit(int[][] sudu,int num,int row,int col){
		
		for (int i = 0; i < sudu.length; i++) {
			if (sudu[row][i]==num) {
				return false;
			}
		}
		for (int i = 0; i < sudu.length; i++) {
			if (sudu[i][col]==num) {
				return false;
			}
		}
		//检查粗线宫是否可行
		//起始行列
		int row1 = (row/3)*3;
		int col1 = (col/3)*3;
		for (int i = row1; i < row1+3; i++) {
			for (int j = col1; j < col1+3; j++) {
				if (sudu[i][j]==num) {
					return false;
				}
			}
		}
		return true;
	}
}
