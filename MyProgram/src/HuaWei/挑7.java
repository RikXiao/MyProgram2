package HuaWei;

import java.util.Scanner;
import java.util.Stack;

public class 挑7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int Max = in.nextInt();
			int count =0;
			for (int i = 7; i <=Max; i++) {
				if(i%7==0){
					count++;
					continue;
				}else {
					int num =i;
					while(num!=0){
						int yu = num%10;
						if (yu==7) {
							count++;
							break;
						}else {
							num = num/10;
						}
					}
				}
			}
			System.out.println(count);
		}

	}

}
