package HuaWei;

import java.util.Scanner;

public class 进制转换 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String hex = in.next();
			hex = hex.substring(2);
			Integer data = Integer.valueOf(hex, 16);
			System.out.println(data);
		}

	}

}
