package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 组成偶数最接近的两个素数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int even = in.nextInt();
			if (even%2==0&&even>2) {
				int[] result = getOddS(even);
				System.out.println(result[0]);
				System.out.println(result[1]);
			}
			else {
				System.out.println("输入错误");
			}
		}
		in.close();

	}
	
	public static int[] getOddS(int data){
		int[] result = new int[2];
		int other =0;
		int minDiffer=-1;
		for (int i = 3; i <  data/2+1; i++) {
			if (isOdd(i)) {
				other=data-i;
				if (isOdd(other)) {
					int differ = Math.abs(i-other);
					if (minDiffer==-1||differ<minDiffer) {
						result[0]=i;
						result[1]=other;
						minDiffer=differ;
					}
				}
			}		
		}
		return result;
	}
	
	public static boolean isOdd(int data){
		boolean flag = true;
		if (data<=1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(data); i++) {
			if (data%i==0) {
				flag=false;
				break;
			}
		}
		return flag;
	}

}
