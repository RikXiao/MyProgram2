package NiuKe;

import java.util.Arrays;
import java.util.Scanner;

public class 排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.next();
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			s = String.valueOf(arr);
			int index = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]>='0'&&arr[i]<='9') {
					index =i;
				}else {
					break;
				}
			}
			if (index>=0) {
				String a = s.substring(0,index+1);
				String b = s.substring(index+1);
				System.out.println(b+a);
			}else {
				System.out.println(s);
			}
		}
	}

}
