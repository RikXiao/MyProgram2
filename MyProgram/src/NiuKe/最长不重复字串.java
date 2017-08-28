package NiuKe;

import java.util.Arrays;
import java.util.HashMap;

public class 最长不重复字串 {

	
	public static void main(String[] args) {
		String aString = "abcacrfy";
		System.out.println(getMax(aString.toCharArray()));
	}
	
	public static int getMax(char[] arr){
		
		HashMap<Character, Integer> map = new HashMap<>();//某个字符当前已遍历字串最后一次出现的位置
		int[] result = new int[arr.length];//记录以i为结尾的最长不重复字串长度
		//int[] result = new int[arr.length];//记录以i为结尾的最长不重复字串的起始位置
		Arrays.fill(result, -1);
		result[0]=1;
		map.put(arr[0], 0);
		
		for (int i = 1; i < arr.length; i++) {
			char th = arr[i];
			Integer lastIndex = map.get(th);//th字符在i之前最后一次出现的位置
			if (lastIndex==null) {//如果从未出现
				result[i] = result[i-1]+1;
			}else if (lastIndex<i-result[i-1]) {//出现在前面一个最长字串开始的位置之前
				result[i] = result[i-1]+1;
			}else {
				result[i] = i-lastIndex;
			}
			map.put(arr[i], i);
		}
			
		int count=0;
		for (int i = 0; i < result.length; i++) {
			if (result[i]>count) {
				count=result[i];
			}
		}
		return count;
		
	}
	//O(N^2)
	public int getn2(char[] arr){
		HashMap<Character, Integer> map = new HashMap<>();//
		int[] result = new int[arr.length];//
				
		for (int i = 0; i < arr.length; i++) {
			map.clear();
		  for (int j = i; j < result.length; j++) {
				char ch = arr[j];
				if (map.containsKey(ch)) {					
					break;
				} else {
					map.put(ch, 1);
				}
			}
		  result[i] = map.size();
		}
			
		int count=0;
		for (int i = 0; i < result.length; i++) {
			if (result[i]>count) {
				count=result[i];
			}
		}
		return count;
	}
}
