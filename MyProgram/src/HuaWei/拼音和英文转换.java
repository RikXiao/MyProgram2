package HuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 拼音和英文转换 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	/*	String yingwen = "OneTwoThreeFourFiveSixSevenEightNineZero";
		String pinying = "YiErSanSiWuLiuQiBaJiuLing";*/
		HashMap<String, String> map = new HashMap<>();
		map.put("One", "Yi");
		map.put("Two", "Er");
		map.put("Three", "San");
		map.put("Four", "Si");
		map.put("Five", "Wu");
		map.put("Six", "Liu");
		map.put("Seven", "Qi");
		map.put("Eight", "Ba");
		map.put("Nine", "Jiu");
		map.put("Zero", "Ling");
		map.put("Yi", "One");
		map.put("Er", "Two");
		map.put("San", "Three");
		map.put("Si", "Four");
		map.put("Wu", "Five");
		map.put("Liu", "Six");
		map.put("Qi", "Seven");
		map.put("Ba", "Eight");
		map.put("Jiu", "Nine");
		map.put("Ling", "Zero");
		while(scanner.hasNext()){
			String input = scanner.next();
			ArrayList<String> list = new ArrayList<>();
			int len = input.length();
			boolean flag = true;
			while(len!=0){
				//System.out.println(1);
				for (int i = 1; i < len; i++) {
					char ch = input.charAt(i);
					if (ch>='A'&&ch<='Z'||ch>='a'&&ch<='z') {
						
						if (ch>='A'&&ch<='Z') {
							String s = input.substring(0, i);
							list.add(s);
							input = input.substring(i);
							len = input.length();
							break;
						}
						if (i == len-1) {
							list.add(input);						
							len = 0;
						}	
					}else {
						len =0;
						flag = false;
						break;
					}										
				}
			}
			if (flag) {
				String outString = "";
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i);
					if (s.equals("Double")) {
						String next = list.get(i+1);
						String out = map.get(next);
						if (out==null) {
							outString = "ERROR";
							break;
						}
						outString+=out;										
						outString+=out;										
						i++;
					}else {
						String out = map.get(s);
						if (out==null) {
							outString = "ERROR";
							break;
						}
						outString+=out;
					}				
				}
				System.out.println(outString);
			}else {
				System.out.println("ERROR");
			}
			
		}

	}

	
}
