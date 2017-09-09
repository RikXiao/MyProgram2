package NiuKe;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class 括号匹配 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			if (str.equals("")) {
				System.out.println(0);
				break;
			}
			HashMap<String, Integer> map = new HashMap<>();			
			System.out.println(getMax(str,map));
		}
       in.close();
	}

	public static int getMax(String str, HashMap<String, Integer> map) {
		if (str.equals("")) {
			return 1;
		}
		if (map.get(str) != null) {
			return map.get(str);
		}
		String child = str.replaceFirst("\\(", "");// 首先去掉第一个左括号
		int total = totalNum(child);// 右括号的个数
		// 逐ge去掉右括号，判断是否合法
		String next = "";
		int sum = 0;
		for (int i = 1; i <= total; i++) {
			next = repalceI(i, child);
			if (isTrue(next)) {
				sum += getMax(next, map);
			}
		}
		map.put(str, sum);
		return sum;

	}
	
	//替换第i个右括号
	public static String repalceI(int i,String child){
		int index = 0;
		int len = child.length();
		for (int j = 0; j < len; j++) {
			if (child.charAt(j)==')') {
				index++;
				if (index==i) {
					return child.substring(0, j)+child.substring(j+1);
				}
			}
		}
		return "";
	}
	//右括号总数
	public static int totalNum(String child){
		int length = child.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (child.charAt(i)==')') {
				count++;
			}
		}
		return count;
	}

	public static boolean isTrue(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]=='(') {
				stack.push(arr[i]);
			}else {
				if (stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
				
			}
		}
		if (stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	
}
