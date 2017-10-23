package LeetCode;

import java.util.Scanner;

public class 解方程 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print(solveEquation(in.nextLine()));

	}
	  public static String solveEquation(String equation) {
			// 例如：equation = "2x+5-3+x=6+x-2";
			// return "Infinite solutions"; // 无穷解
			// return "No solution"; // 无解
          String[] arr = equation.split("=");
          int leftx = 0;
          //左边x的系数
          for (int i = 0; i < arr[0].length(); i++) {
			char ch = arr[0].charAt(i);
			if (ch=='x') {
				if (i==0) {
					leftx+=1;
				}else {
					char pre = arr[0].charAt(i-1);
					if (pre=='-') {
						leftx=leftx-1;
					}else if(pre == '+'){
						leftx = leftx+1;
					}else {
						if (i-1==0) {
							leftx = leftx +Integer.valueOf(pre);
						}else if(arr[0].charAt(i-2)=='+') {
							leftx = leftx + Integer.valueOf(pre);
						}else {
							leftx = leftx - Integer.valueOf(pre);
						}
					}
				}
			}
		  }
          //右边x的系数
          int rightx = 0;
          for (int i = 0; i < arr[1].length(); i++) {
			char ch = arr[1].charAt(i);
			if (ch=='x') {
				if (i==0) {
					rightx+=1;
				}else {
					char pre = arr[1].charAt(i-1);
					if (pre=='-') {
						rightx=rightx-1;
					}else if(pre == '+'){
						rightx = rightx+1;
					}else {
						if (i-1==0) {
							rightx = rightx +Integer.valueOf(pre);
						}else if(arr[1].charAt(i-2)=='+') {
							rightx = rightx + Integer.valueOf(pre);
						}else {
							rightx = rightx - Integer.valueOf(pre);
						}
					}
				}
			}
		  }
          //求左边常量
          int left = 0;
          int length = arr[0].length();
          for (int i = 0; i < length; i++) {
			char ch = arr[0].charAt(i);
			
			if (ch>='0'&&ch<='9') {
				if (i==length-1) {
					char pre = arr[0].charAt(i-1);
					if (pre == '-') {
						left-=Integer.valueOf(ch);
					}else {
						left+=Integer.valueOf(ch);
					}
				}else {
					char next = arr[0].charAt(i+1);
					if (next!='x') {//是常量
						if (i==0) {
							left +=Integer.valueOf(ch);
						}else  {
							char pre = arr[0].charAt(i-1);
							if (pre == '-') {
								left-=Integer.valueOf(ch);
							}else {
								left+=Integer.valueOf(ch);
							}
						}
					}
				}
			}
		  }
          //求右边常量
          int right = 0;
          int length2 = arr[1].length();
          for (int i = 0; i < length2; i++) {
			char ch = arr[1].charAt(i);
			
			if (ch>='0'&&ch<='9') {
				if (i==length2-1) {
					char pre = arr[1].charAt(i-1);
					if (pre == '-') {
						left-=Integer.valueOf(ch);
					}else {
						left+=Integer.valueOf(ch);
					}
				}else {
					char next = arr[1].charAt(i+1);
					if (next!='x') {//是常量
						if (i==0) {
							left +=Integer.valueOf(ch);
						}else  {
							char pre = arr[1].charAt(i-1);
							if (pre == '-') {
								left-=Integer.valueOf(ch);
							}else {
								left+=Integer.valueOf(ch);
							}
						}
					}
				}
			}
		  }
          int a = leftx-rightx;
          int b = right-left;
          if (a ==0&&b==0) {
			return "Infinite solutions";
		}else if(a==0&&b!=0) {
			return "No solution";
		}else {
			return "x="+b/a; // 有解
		}
          
      }

}
