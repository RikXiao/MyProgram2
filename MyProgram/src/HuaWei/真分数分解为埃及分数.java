package HuaWei;

import java.util.Scanner;

public class 真分数分解为埃及分数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String data = in.nextLine();
			String[] arr = data.split("/");
			int a = Integer.valueOf(arr[0]);
			int b = Integer.valueOf(arr[1]);
			System.out.println(getEJ(a, b));
			
		}

	}
	public static String getEJ(int a,int b){
		if (a==0||b==0) {
			return "错误";
		}
		String result = "";
		while(true){
			int c ;
			if (b%a==0) {				
			    c =b/a;
			    a=1;
			}else {
				c=b/a+1;
			}
			if (result.length()==0) {
				result=result+"1/"+c;
			}else {
				result = result+"+"+"1/"+c;
			}
			if (a==1) {
				break;
			}
			a = a*c-b;
			b = b*c;
			
		}
		return result;
	}

}
