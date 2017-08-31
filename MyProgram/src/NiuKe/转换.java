package NiuKe;
import java.util.HashMap;
import java.util.Scanner;

public class 转换 {

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
			//ArrayList<String> list = new ArrayList<>();
			int len = input.length();			
			char[] arr = new char[2*len];
			boolean is = true;
			int index =1;
			arr[0] = input.charAt(0);
			for (int i = 1; i < len; i++) {
				char ch = input.charAt(i);
				if (ch>='A'&&ch<='Z'||ch>='a'&&ch<='z') {
					if (ch>='A'&&ch<='Z') {
						arr[index++] = '#';
					}
					arr[index++]=ch;
				}else {
					is = false;
					break;
				}
			}
			
			if (is) {
				String outString  = "";
				String inString = String.valueOf(arr).trim();
				String[] strings = inString.split("#");
				for (int i = 0; i < strings.length; i++) {
					String s = strings[i];
					if (s.equals("Double")&&i!=strings.length-1) {
						String next = strings[i+1];
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
	public String numToString(String s){
		String dict = "abcdefghijklmnopqrstuvwxyz";
		int input = Integer.valueOf(s);
		String out = "";
		int left  = 0;
		while(input!=0){
			left = input%26;
			input = input/26;
			out = dict.charAt(left-1)+out;			
		}	
		return out;
	}
	
}
