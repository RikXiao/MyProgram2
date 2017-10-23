package NiuKe;

import java.util.HashMap;

public class 数字个数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int result = 0;
	    for (int j = 3000; j < 3999; j++) {
	    	HashMap<Character, Integer> map = new HashMap<>();
	    	String n = String.valueOf(j);
				char[] arr = n.toCharArray();				
				for (int i = 0; i < arr.length; i++) {
					if(map.containsKey(arr[i])){
						map.put(arr[i], map.get(arr[i])+1);
					}else {
						map.put(arr[i], 1);
					}
				}
				int k = 0;
				for (Character ch:map.keySet()) {
					if (map.get(ch)==2) {
						k++;
					}
				}
				if (k==1) {
					result++;
				}
		}
				
		System.out.println(result);        
	}

}
