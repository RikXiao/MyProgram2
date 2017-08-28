package HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 第一个出现一次的字符 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			System.out.println(firstChar(input));
		}

	}
	
	public static String firstChar(String input){
		int length = input.length();
		if (length>0) {
			char[] arr = input.toCharArray();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < arr.length; i++) {
				char thec = arr[i];
				Integer num =map.get(thec);
				if (num==null) {
					map.put(thec, 1);
				}else {
					map.put(thec, num+1);
				}
			}
			for (int i = 0; i < arr.length; i++) {
				Integer count = map.get(arr[i]);
				if (count==1) {
					return arr[i]+"";
				}
			}
			
			
		}
		return "-1";
		
		
	}

}
