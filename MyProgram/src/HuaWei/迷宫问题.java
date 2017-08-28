package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 迷宫问题 {

	public static ArrayList<String> result = new ArrayList<>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int row = in.nextInt();
			int col = in.nextInt();
			int mat[][] = new int[row][col];
			boolean flag[] = new boolean[row*col];//标志位，用以区分该格是否已经走过
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					mat[i][j]=in.nextInt();
				}
			}
			ArrayList<String> list = new ArrayList<>();
			getPath(row, col, mat, 0, 0, flag, list);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
	
	public static boolean getPath(int row,int col,int[][] mat,int x,int y,boolean[] flag,ArrayList<String> list){
		if (x>=row||x<0||y<0||y>=col) {
			return false;
		}
		boolean result = false;
		if(flag[x*col+y]==false){//如果标志位false表示没有走过，true为走过则返回，
			if (mat[x][y]==0) {//为0表示可以走，否则返回
				flag[x*col+y]=true;
				list.add("("+x+","+y+")");
				if (x==row-1&&y==col-1) {//是否到了最后一个
					迷宫问题.result = new ArrayList<>(list);
					result = true;
				}else {					
					result=getPath(row, col, mat, x+1, y, flag, list)||
					       getPath(row, col, mat, x-1, y, flag, list)||
					       getPath(row, col, mat, x, y+1, flag, list)||
					       getPath(row, col, mat, x, y-1, flag, list);
					if (!result) {
						list.remove(list.size()-1);
						flag[x*col+y]=false;
					}
					
					
				}
															
			}
		}		
		return result;
	}

}
