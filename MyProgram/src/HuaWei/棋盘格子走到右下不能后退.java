package HuaWei;

import java.util.Scanner;

public class 棋盘格子走到右下不能后退 {

	/**
	 * @param args
	 */
	public static int total = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){//从0开始算，这里算是下标的最大值（实际个数要加1）
			total=0;
			int col = in.nextInt();
			int row = in.nextInt();
			findPath(row, col, 0, 0);
			System.out.println(total);
		}

	}
	
	public static void findPath(int row,int col,int x,int y){
		if (x==row&&y==col) {
			total++;
		}
		if (x<=row&&x>=0&&y>=0&&y<=col) {
			findPath(row, col, x+1, y);
			findPath(row, col, x, y+1);
		}
		
	}

}
