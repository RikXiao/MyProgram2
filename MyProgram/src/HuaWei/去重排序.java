package HuaWei;

import java.util.Scanner;
import java.util.TreeSet;

public class 去重排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeSet<Integer> data = new TreeSet<>();
		while(in.hasNext()){
			int size = in.nextInt();
			for (int i = 0; i < size; i++) {
				data.add(in.nextInt());
			}
			for (Integer i:data) {
				System.out.println(i);
			}
			data.clear();
		}
		

	}

}
