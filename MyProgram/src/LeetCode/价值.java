package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 价值 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			int k = Integer.valueOf(in.nextLine());
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				Integer num = map.get(ch);
				if (num == null) {
					map.put(ch, 1);
				}else {
					map.put(ch, num+1);
				}
			}
			int size = map.size();
			int[] arr = new int[size];
			int index = 0;
			for (char ch : map.keySet()) {
				arr[index++] = map.get(ch);
			}
			int result = getMin(arr, k, size);
			System.out.println(result);
		}

	}
	
	public static int getMin(int[] arr,int k,int len){
		if (k>0) {
			Arrays.sort(arr);
			arr[len-1]-=1;
			k--;
			return getMin(arr, k, len);
		}else {
			int result = 0;
			for (int i = 0; i < len; i++) {
				result=result+arr[i]*arr[i];
			}
			return result;
		}
	}

}
