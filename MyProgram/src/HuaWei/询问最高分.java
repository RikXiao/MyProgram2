package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 询问最高分 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();//学生数
			int m = in.nextInt();//操作数
			int[] grade = new int[n];
			for (int i = 0; i < grade.length; i++) {
				grade[i] = in.nextInt();
			}
			String action = null;
			int left ;
			int right;
			ArrayList<Integer> result = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				action = in.next();
				left = in.nextInt();
				right = in.nextInt();
				if (action.equals("Q")) {
					int max = findMax(grade, left-1, right-1);
					result.add(max);
				}
				if (action.equals("U")) {
					update(grade, left-1, right);
				}
			}
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}

	}

	public static int findMax(int[] grade,int left,int right){
		if (left>right) {
			int tmp = left;
			left = right;
			right = tmp;
		}
		
		if (left<=right&&grade.length>right&&left>=0) {
			int max = grade[left];
			for (int i = left+1; i <=right; i++) {
				if (grade[i]>max) {
					max = grade[i];
				}
			}
			return max;
		}else {
			return -1;
		}
	}
	
	public static void update(int[] grade,int id,int num){
		if (id<grade.length&&id>=0) {
			grade[id] = num;
		}else {
			System.out.println("错误");
		}
	}
}
