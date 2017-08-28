package HuaWei;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class 字节截取字符串 {


	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String inputString = in.nextLine();
            
			String length = in.nextLine();
            
			System.out.println(cutString(inputString, Integer.valueOf(length)));
			
		}
		
	}
	public static String cutString(String input,int length){
        if(input.length()>0){
            int index =-1;
		for (int i = 0; i < input.length(); i++) {
			if (length==0) {
				break;
			}
			char c = input.charAt(i);
			if (c >= 19968 && c <= 171941) {
				length = length-2;
			}else {
				length =length-1;
			}
			if (length<0) {
				index=i-1;
				break;
			}else {
				index=i;
			}
		}
		if (index>=0) {
			return input.substring(0,index+1);
		}
        }
            return "kong";
			
	}


}
