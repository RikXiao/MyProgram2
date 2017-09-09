package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class 字符串碎片 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.next();
			char[] arr = str.toCharArray();
			HashMap<String, Integer> map = new HashMap<>();
			String child = ""+arr[0];
			char last = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i]==last) {
					child+=arr[i];
				}else {
					//先保存前一个碎片
					Integer num = map.get(child);
					if (num==null) {
						map.put(child, 1);
					}else {
						map.put(child, num+1);
					}
					//然后开始新的碎片
					child = arr[i]+"";
					last = arr[i];
				}
			}
			Integer num = map.get(child);
			if (num==null) {
				map.put(child, 1);
			}else {
				map.put(child, num+1);
			}
			//计算总个数和总长度
			int totalLen = 0;
			int count = 0;
			for (String key:map.keySet()) {
				int num2 = map.get(key);
				count+=num2;
				totalLen += key.length()*num2;
			}
			System.out.println(String.format("%.2f", totalLen/(count*1.0)));
		}

	}

}
