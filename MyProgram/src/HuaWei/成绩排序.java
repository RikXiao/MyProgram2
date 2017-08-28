package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 成绩排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		成绩排序  p = new 成绩排序();
		while(in.hasNext()){
			ArrayList<grade> list = new ArrayList<>();
			int num = in.nextInt();
			int flag = in.nextInt();
			for (int i = 0; i < num; i++) {
				grade ga = p.new grade();
				ga.name = in.next();
				ga.score = in.nextInt();
				list.add(ga);
			}
			sort(list, flag);
			for (int i = 0; i < num; i++) {
				grade a = list.get(i);
				System.out.println(a.name+" "+a.score);
			}
			
		}
		

	}
	
	 class grade{
		String name;
		int score;
		
	}
	 public static void sort(ArrayList<grade> list,int flag){//使用冒泡排序才可以保持稳定性（归并排序也是稳定的）相等的元素不改变相对位置
		 for (int i = 0; i < list.size()-1; i++) {
			for (int j = 0; j < list.size()-i-1; j++) {
				grade a = list.get(j);
				grade b = list.get(j+1);
				if (flag==0) {
					if (b.score>a.score) {
						list.set(j, b);
						list.set(j+1, a);						
					}
				}else {
					if (b.score<a.score) {
						list.set(j, b);
						list.set(j+1, a);						
					}
				}
			}
		}
	 }

}
