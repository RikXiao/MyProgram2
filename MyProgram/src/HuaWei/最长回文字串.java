package HuaWei;

import java.util.Scanner;

public class 最长回文字串 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String inputString = in.nextLine();
			System.out.println(getMaxHuiWen(inputString));
		}
	}
	
	public static int getMaxHuiWen(String input){
		int length = input.length();
		if (length==0) {
			return 0;
		}
		char[] chArr = input.toCharArray();
		int[] result = new int[length];
		int max =0;
		int index=0;
		for (int i = 0; i < length; i++) {
			//第一种以当前字符为中心的最长回文
			int count1=1;
			for (int j = 1; (i-j)>=0&&(i+j)< length; j++) {
				if (chArr[i-j]==chArr[i+j]) {
					count1+=2;
				}else {
					break;
				}				
			}
			//以当前字符右侧为中心
			int count2 =0;
			for (int j = 0; (i-j)>=0 &&(i+j+1)< length; j++) {
				if (chArr[i-j]==chArr[i+j+1]) {
					count2+=2;
				}else {
					break;
				}
			}
			result[i] = Math.max(count1, count2);
			if(result[i]>max){
				max=result[i];
				//通过奇偶数来判断是哪种情况
				if (max%2==0) {
					index=i-(max/2)+1;
				}else {
					index = i-max/2;
				}
			}
		}
		return max;
	}

}
