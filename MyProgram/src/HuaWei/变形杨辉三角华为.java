package HuaWei;

import java.util.Scanner;

public class 变形杨辉三角华为 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int num = in.nextInt();
			int[][] arrys = new int[num][];
			for (int i = 0; i < num; i++) {
				arrys[i] = new int[2 * i + 1];
			}
			getyanghuiTriangle(num, arrys);
			int i;
			for (i = 0; i < arrys[num - 1].length; i++) {
				if (arrys[num - 1][i] % 2 == 0) {
					System.out.println(i + 1);
					break;
				}
			}
			if (i == arrys[num - 1].length) {
				System.out.println("-1");
			}
		}
		in.close();
	}

	public static void getyanghuiTriangle(int num, int[][] arrys) {
		int num1;
		int num2;
		int num3;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < arrys[i].length; j++) {
				if (i == 0 || j == 0 || j == arrys[i].length - 1) {
					arrys[i][j] = 1;
				} else {
					if (j - 2 < 0) {
						num1 = 0;
					} else {
						num1 = arrys[i - 1][j - 2];
					}
					if (j - 1 < 0) {
						num2 = 0;
					} else {
						num2 = arrys[i - 1][j - 1];
					}
					if (j >= arrys[i - 1].length) {
						num3 = 0;
					} else {
						num3 = arrys[i - 1][j];
					}
					arrys[i][j] = num1 + num2 + num3;
				}
			}
		}
	}

}