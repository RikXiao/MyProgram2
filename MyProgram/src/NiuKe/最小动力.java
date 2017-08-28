package NiuKe;

import java.util.Scanner;

public class 最小动力 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int row = in.nextInt();
			int col = in.nextInt();
			int[][] arr = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			System.out.println(minData(arr, row, col));
		}

	}
	
	public static int minData(int[][] arr,int row,int col){
		if (row<1||col<1) {
			return -1;
		}
		int[][] min = new int[row+1][col+1];
		int[][] left = new int[row+1][col+1];
		for (int i = 0; i <= col; i++) {
			min[0][i] = 100000000;
			left[0][i] = -100000000;
			
		}
		for (int i = 0; i <= row; i++) {
			min[i][0] = 100000000;
			left[i][0] = -100000000;
		}

		min[0][1]=1;
		left[0][1] = 1;
		left[1][0] = 1;
		min[1][0]=1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <=col; j++) {
				if (arr[i-1][j-1]>=0) {//如果当前大于0
					if (min[i-1][j]>min[i][j-1]) {
						min[i][j] = min[i][j-1];
						left[i][j] = left[i][j-1]+arr[i-1][j-1];//更新min和left，left记得要加上当前的值
					}else {
						min[i][j] = min[i-1][j];
						left[i][j] = left[i-1][j]+arr[i-1][j-1];
					}
				}else {//如果当前小于0；
					//从上面下来需要的最小
					int a = left[i-1][j]+arr[i-1][j-1];//看从上面下来是否还有剩余动力
					int min1 =0;
					if (a>0) {//有剩余动力就不用更新最小初始动力
						min1 = min[i-1][j];
					}else {//没有剩余动力了，那就要给初始动力加上一个数，使得到该格时剩余动力至少为1
						min1 = min[i-1][j]+Math.abs(a)+1;
					}
					//从旁边来，跟上面类似
					int b = left[i][j-1]+arr[i-1][j-1];
					int min2 = 0;
					if (b>0) {
						min2 = min[i][j-1];
						
					}else {
						min2 = min[i][j-1]+Math.abs(b)+1;
					}
					//比较从上面来和从旁边过来，哪种方式初始动力小，就选择哪种，并更新相应的剩余动力
					if (min1<min2) {
						min[i][j] = min1;
						if (a>0) {
							left[i][j] = a;
						}else {
							left[i][j] =1;
						}
					}else if (min2<min1) {
						min[i][j] = min2;
						if (b>0) {
							left[i][j] = b;
						}else {
							left[i][j] =1;
						}
					} else {//两种方式的初始动力如果相同，就选择剩余动力大的一个
						min[i][j] = min2;
						left[i][j] = Math.max(a, Math.max(1, b));
					}
				}
			}
		}
		return min[row][col];
	}
	

}
