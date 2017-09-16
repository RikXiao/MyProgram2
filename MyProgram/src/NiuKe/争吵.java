package NiuKe;

import java.util.HashMap;

public class 争吵 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String getMinStr(String str,HashMap<String, String> map){
		int len = str.length();
		
		if (map.get(str)!=null) {
			map.get(str);
		}
		char[] arr = str.toCharArray();
		String result = null;
		for (int i = 1; i <len; i++) {
			if (arr[i]=='L'&&arr[i-1]=='R') {
				String str1 = getMinStr(str.substring(0,i-1)+str.substring(i), map);
				String str2 = getMinStr(str.substring(0,i)+str.substring(i+1), map);
				String min = str1.length()<str2.length()?str1:str2;
				if (result == null) {
					result = min;
				}else {
					if (min.length()<result.length()) {
						result = min;
					}
				}
			}
		}
		if (result == null) {
			map.put(str, str);
			return str;
		}else {
			map.put(str, result);
			return result;
		}
	}

}
