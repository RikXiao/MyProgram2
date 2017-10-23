package NiuKe;

import java.util.Arrays;
import java.util.Scanner;

public class 数字字串 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			str = str.replace("RED", "");
			String[] arr = str.split("[A-Z]+");
			String result = "-1";
			for (int i = 0; i < arr.length; i++) {
				if (!arr.equals("")) {
					if (Integer.valueOf(arr[i])>Integer.valueOf(result)) {
						result = Integer.valueOf(arr[i])+"";
					}
				}
				
			}
			if (result.equals("-1")) {
				System.out.println(-1);
			}else {
				System.out.println(result);
			}
			
		}
        in.close();
	}

}
