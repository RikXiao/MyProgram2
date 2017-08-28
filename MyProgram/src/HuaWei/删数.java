package HuaWei;

import java.util.Scanner;

public class 删数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			boolean[] flag = new boolean[num];
			int index =0;
			int count =0;
			while(num>1){
				if (index==flag.length) {
					index=0;
				}				
				if (flag[index]==false) {
					if (count==2) {
						flag[index]=true;
						num--;
						count=0;
					}else {
						count++;
					}
				}
				index++;
			}
			//System.out.println("22");
			for (int i = 0; i < flag.length; i++) {
				if (flag[i]==false) {
					System.out.println(i);
				}
			}
		}

	}

}
