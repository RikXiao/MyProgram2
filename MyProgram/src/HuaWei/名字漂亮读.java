package HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class 名字漂亮读 {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int Num = in.nextInt();
			in.nextLine();
			String Names[] = new String[Num];
			for (int i = 0; i<Num; i++) {
				Names[i]= in.nextLine();
			}
			for (int i = 0; i < Names.length; i++) {
				System.out.println(getMax(Names[i]));
			}
		}

	}
	
	public static int getMax(String name){
		int[] flag = new int[26];
		for (int i = 0; i < name.length(); i++) {
			char thec = name.charAt(i);
			if (thec>='a'&&thec<='z') {
				flag[thec-'a']++;
			}else {
				flag[thec-'A']++;
			}
					
		}
		Arrays.sort(flag);
		int sum = 0;
		for (int i = 0; i < flag.length; i++) {
			sum = sum+flag[i]*(i+1);
		}
		return sum;
	}

}
