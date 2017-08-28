package HuaWei;

import java.util.Scanner;

public class 最长公共字串 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			if (s1.length()>s2.length()) {//s1存放短的字符串
				String s3 = s1;
				s1 = s2;
				s2 = s3;
			}
			String subs = getMaxSub(s1, s2);
			System.out.println(subs);
			
		}

	}
	//动态递推法（最好理解的）（递归不好搞）
	public static String getMaxSub(String s1, String s2){
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int[][] len =new int[arr1.length][arr2.length];
		int maxL =0;
		int index=0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i]==arr2[j]) {
					if (i==0||j==0) {
						len[i][j]=1;
					}else {
						len[i][j]=len[i-1][j-1]+1;
					}
				}else {
					len[i][j]=0;
				}
				if (len[i][j]>maxL) {
					maxL=len[i][j];
					index = i-maxL+1;
				}
			}			
		}
		if (maxL>0) {
			return s1.substring(index, index+maxL);
		}else {
			return "无公共字串";
		}
	}
	//动态递归法//使用for循环调用maxSeq（求以某个字符串为结尾的最大字串长度）
	/*public static int maxSeq(char[] x,char[] y,int xi,int yi,int[][] result){
		if (xi==x.length||yi==y.length) {
			return 0;
		}
		
		if (x[xi]==y[yi]) {//xi和yi匹配的最大字串，最好
		    
			int tmp = 1+maxSeq(x, y, xi-1, yi-1,result);
			if (tmp>max) {
				max = tmp;//记录最大的长度
				indexi = x;//最大长度的结束位子
			}
		}else {
			
			return 0;
		}
		
		
		return 0;
	}*/

}
