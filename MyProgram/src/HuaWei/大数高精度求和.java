package HuaWei;

import java.math.BigInteger;
import java.util.Scanner;

public class 大数高精度求和 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String a = in.nextLine();
			String b = in.nextLine();
			BigInteger aBigInteger = new BigInteger(a);
			BigInteger bBigInteger = new BigInteger(b);
			System.out.println(aBigInteger.add(bBigInteger));
		}

	}

}
