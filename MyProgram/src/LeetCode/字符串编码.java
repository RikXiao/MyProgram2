package LeetCode;

import java.util.Scanner;

public class 字符串编码 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			String result = encoding(str);
			System.out.println(result.length());			
		}

	}

	public static String encoding(String str){
		
		String out = str;
		int len = str.length();
		int next = len/2;
		String sub = "";
		int k = 0;
		int size = 0;
		while(next>0){
			String pre = str.substring(0, next);
			String leftStr = str.substring(next);
			if (leftStr.startsWith(pre)) {
				k=2;
				sub = pre;
				size = sub.length();
				String str1 = leftStr.substring(size);
				if (size != 0) {					
					   while(str1.startsWith(sub)){
						  k++;
						  str1 = str1.substring(size);
					   }
					   String tmp = encoding(sub);
					   String result = k+"["+tmp+"]"+encoding(str1);
					   if (result.length()<out.length()) {
						    out = result;
					   }
					}
			}
		    next--;
		}
		
		return out;
	}
}
