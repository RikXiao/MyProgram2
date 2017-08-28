package NiuKe;

import java.util.Scanner;

public class a {

	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.nextLine();
			int legth = s.length();
			if (legth>20||legth==0) {
				System.out.println("ERROR!");
			}
			else {
				char[] arr = s.toCharArray();
				String result = "";
				for (int i = 0; i < arr.length; i++) {
					char ch = arr[i];
					if (ch>='0'&&ch<='9'||ch>='a'&&ch<='z'||ch>='A'&&ch<='Z') {
						if (i%2==0) {
							result+=ch;
						}
					}else {
						result = "ERROR!";
						break;
					}
				}
				System.out.println(result);
			}
			
		}
		in.close();
	}
}
