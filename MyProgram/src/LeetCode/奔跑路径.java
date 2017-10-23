package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class 奔跑路径 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		while(in.hasNext()){
			int row = in.nextInt();
			int col = in.nextInt();
			int[][] arr = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			boolean[][] flag = new boolean[row][col];
			int max = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					int a = getLongest(arr, i, j, row, col, flag, 100000);
					if (a>max) {
						max = a;
					}
				}
			}
			list.add(max);
		}
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		in.close();
	}

	public static int getLongest(int[][] arr,int x,int y,int row,int col,boolean[][] flag,int last){
		if (x>=0&&x<row&&y>=0&&y<col) {
			if (!flag[x][y]&&arr[x][y]<last) {
				int res = 1;
				flag[x][y] = true;
				int a = Math.max(getLongest(arr, x, y-1, row, col, flag, arr[x][y]), getLongest(arr, x, y+1, row, col, flag, arr[x][y]));
				int b = Math.max(getLongest(arr, x+1, y, row, col, flag, arr[x][y]), getLongest(arr, x-1, y, row, col, flag, arr[x][y]));
				res+=Math.max(a, b);
				flag[x][y] = false;
				return res;
			}
		}
		return 0;
	}
}
