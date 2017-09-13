package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 腾讯笔试最短路径VS可以有k次减半 {

	/**
	 * 求从0号城市到1号城市的最短路径
	 */
	public static double min = 10000000;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			ArrayList<Integer> list = new ArrayList<>();
			boolean[] flag = new boolean[n];
			findPath(arr, 0, list, flag, 1, k);
			System.out.println(min);
		}

	}
	
	public static void findPath(int[][] arr,int src,ArrayList<Integer> list,boolean[] flag,int target,int k){
		if (src==target) {//如果到了目标节点找出路径的距离
			ArrayList<Integer> tmp = new ArrayList<>(list);
			Collections.sort(tmp);
			int size = tmp.size();
			double dis = 0;
			int left = k;
			for (int i = size-1; i >= 0; i--) {
				if (left>0) {
					dis+=tmp.get(i)/2.0;
				}else {
					dis+=tmp.get(size);
				}
			}
			if (dis<min) {
				min = dis;
			}
		}else {
			for (int i = 0; i < flag.length; i++) {
				if (!flag[i]&&arr[src][i]!=0) {//该城市没有到过，并且从当前源城市可以到达
					list.add(arr[src][i]);
					flag[i] = true;
					findPath(arr, i, list, flag, target, k);
					
					list.remove(list.size());//恢复现场
					flag[i] = false;
				}
			}
			
		}		
	}

}
