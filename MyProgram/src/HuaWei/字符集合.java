package HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字符集合 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			int length = input.length();
			String result = "";
			for (int i = 0; i < length; i++) {
				char thec= input.charAt(i);
				Integer num = map.get(thec);
				if (num==null) {
					result+=thec;
					map.put(thec, 1);
				}
			}
			System.out.println(result);
		}

	}

}
