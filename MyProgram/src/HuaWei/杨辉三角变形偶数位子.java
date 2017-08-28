package HuaWei;

import java.util.Scanner;

public class 杨辉三角变形偶数位子 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int line = in.nextInt();
			if (line<=2) {
				System.out.println(-1);
			}else if (line%2==1) {
				System.out.println(2);
			}else if (line%4==0) {
				System.out.println(3);
			}else {
				System.out.println(4);
			}
		}

	}

}
