package HuaWei;

import java.util.Scanner;

public class 数独问题 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sudu[][] = new int[9][9];
		while(in.hasNext()){
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudu[i][j] = in.nextInt();
				}
			}
			if (DFS(0, sudu)) {
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
	
	public static boolean DFS(int n,int[][] sudu){
		if (n>80) {
			return true;
		}
		if (sudu[n/9][n%9]!=0) {
			return DFS(n+1,sudu);
		}else {
			for (int i = 1; i <=9; i++) {
				if (check(n, i, sudu)) {
					sudu[n/9][n%9]=i;
					boolean flag = DFS(n+1, sudu);
					if (flag) {
						return true;
					}else {
						sudu[n/9][n%9]=0;
					}
				}
			}
			return false;
		}
		
	}
	
	public static boolean check(int n,int i,int[][] sudu){
		//检查在这一行中，当前位置填入i是否可行
		for (int j = 0; j < 9; j++) {
			if (sudu[n/9][j]==i) {
				return false;
			}
		}
		//检查列中，是否可行
		for (int j = 0; j < 9; j++) {
			if (sudu[j][n%9]==i) {
				return false;
			}
		}
		//检查粗线宫中是否可行
		int row = (n/9)-(n/9)%3;
		int col = (n%9)-(n%9)%3;
		for (int j = (n/9)-(n/9)%3;j < row+3; j++) {
			for (int j1 = (n%9)-(n%9)%3; j1 < col+3; j1++) {
				if (sudu[j][j1]==i) {
					return false;
				}
			}
		}
		return true;
	}

}
