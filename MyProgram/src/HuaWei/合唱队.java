package HuaWei;

import java.util.Scanner;

public class 合唱队 {
	public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
		int num = in.nextInt();
		int[] high = new int[num];

		for (int i = 0; i < num; i++) {
			high[i] = in.nextInt();
		}
		// 动态规划求最大递增子序列数left[i]=max{left[k]}+1;其中high[k]<high[i],并不是所有i之前的最大数
		int[] left = new int[num];// 从左往右依次求每个数作为中间数时左边最大递增子序列的元素个数
		left[0] = 1;
		for (int i = 1; i < left.length; i++) {
			int j = 0, max = 0;
			while (j < i) {
				if (high[j] < high[i]) {
					int maxj = left[j];
					if (maxj > max) {
						max = maxj;
					}
				}
				j++;
			}
			left[i] = max+1;
		}
		// 求从右往左的最大递增子序列元素个数
		int[] right = new int[num];
		right[num - 1] = 1;
		for (int i = num - 2; i >= 0; i--) {
			int j = num - 1, max = 0;
			while (j > i) {
				if (high[j] < high[i]) {
					int maxj = right[j];
					if (maxj > max) {
						max = maxj;
					}
				}
				j--;
			}
			right[i]=max+1;
		}
		int maxResult=0;
		for (int i = 0; i < num; i++) {
			int prot=left[i]+right[i]-1;
			if (prot>maxResult) {
				maxResult=prot;
			}
		}
		System.out.println(num-maxResult);

	}
	in.close();
}
}
