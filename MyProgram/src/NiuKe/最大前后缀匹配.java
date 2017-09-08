package NiuKe;

import java.util.Scanner;

public class 最大前后缀匹配 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			int len = str.length();
			int min = -1;
			for (int i = len-1; i > 0; i--) {
				String child = str.substring(i);
				if (str.startsWith(child)) {
					min = i;
				}
			}
			if (min!=-1) {
				String out = str.substring(0,min)+str;
				System.out.println(out);
			}else {
				System.out.println("ERROR");
			}
		}

	}

}
