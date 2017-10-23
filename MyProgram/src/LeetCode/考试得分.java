package LeetCode;

import java.util.Scanner;

public class 考试得分 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int total = in.nextInt();
			int avg = in.nextInt();
			int[] score = new int[n];
			int[] use = new int[n];
			int sum = 0;
			boolean[] flag = new boolean[n];
			for (int i = 0; i < n; i++) {
				score[i] = in.nextInt();
				sum+=score[i];
				use[i] = in.nextInt();
				if (use[i]==total) {
					flag[i] = true;
				}
			}
			int need = n*avg-sum;
			int out = 0;
			while(need>0){
				int minIndex = getMinIndex(use, flag);
				if (minIndex>=0) {
					int tmp = total-score[minIndex];
					if (tmp>=need) {
						out = out + need*use[minIndex];
						need = 0;
					}else {
						out = out + tmp*use[minIndex];
						need -=tmp;
					}
				}
			}
			System.out.println(out);
		}

	}
public static int getMinIndex(int[] use,boolean[] flag){
	int min = Integer.MAX_VALUE;
	int index = -1;
	for (int i = 0; i < flag.length; i++) {
		if (!flag[i]&&use[i]<min) {
			min = use[i];
			index = i;
		}
	}
	flag[index] = true;
	return index;
}
}
