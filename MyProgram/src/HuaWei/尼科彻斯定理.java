package HuaWei;

import java.util.Scanner;

public class 尼科彻斯定理 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int begin =0;			 //其实由数学公式可得begin=m*(m-1)+1
			for (int i = 1; i < m*m*m; i=i+2) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum=sum+i+2*j;
				}
				if (sum==m*m*m) {
					begin=i;
					break;
				}
			}
			if (begin!=0) {
				for (int i = 0; i < m-1; i++) {
					System.out.print((begin+i*2)+"+");
				}
				System.out.println(begin+(m-1)*2);
			}else {
				System.out.println("错误");
			}
		}

	}

}
