package NiuKe;

import java.util.ArrayList;
import java.util.Scanner;

public class 进制转换 {

	public static void main(String[] args) {
		String index = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int target = in.nextInt();
			String data = in.next();
			char[] arr = data.toCharArray();
			int sum =0;//转换10进制
			for (int i = 0; i < arr.length; i++) {
				char ch = arr[i];
				int chT10 = index.indexOf(ch);
				sum = sum*n+chT10;
			}
			//10进制转换target进制
			int left = 0;
			ArrayList<String> result = new ArrayList<>();
			while(sum!=0){
				//取余数
				left = sum%target;
				String a = index.substring(left,left+1);//存余数
				result.add(a);
				//求商
				sum = sum/target;
			}
			String out = "";
			for (int i = result.size()-1; i >=0; i--) {
				out=out+result.get(i);
			}
			
			System.out.println(out);
		}
		in.close();
	}
}
