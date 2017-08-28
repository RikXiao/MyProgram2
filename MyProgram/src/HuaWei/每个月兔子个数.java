package HuaWei;

import java.util.Scanner;

public class 每个月兔子个数 {
	
	public static void main(String[] args) {//斐波拉切尔数列
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int month = in.nextInt();
			int count = getTotalCount(month);
			System.out.println(count);			
		}		
	}
	
	public static int getTotalCount(int monthCount){
		if (monthCount<=0) {
			return 0;
		}
		if (monthCount<3) {
			return 1;
		}
		else{
		    return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);	
		}
		
	}

}
