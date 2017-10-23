package NiuKe;

import java.util.Scanner;

public class n阶乘末尾0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int num = 0, i;  
		    for(i=5; i<=n; i*=5)  
		    {  
		        num += n/i;  
		    }
		    System.out.println(num);
		}

	}

}
