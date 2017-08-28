package HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 简单错误记录 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> names = new ArrayList<>();
		while(in.hasNext()){
			String string1 = in.nextLine();
			String[] inputs = string1.split("\\s+");
			String[] paths = inputs[0].split("\\\\");
			int length = paths.length;
			String name = "";
			if (paths[length-1].length()>16) {
				name = paths[length-1].substring(paths[length-1].length()-16);
			}else {
				name = paths[length-1];
			}
			name = name+" "+inputs[inputs.length-1];
			Integer num = map.get(name);
			if (num==null) {
				map.put(name, 1);
				names.add(name);
			}else {
				map.put(name, num+1);
			}
		}
		int size = names.size();
        int[] counts = new int[size];
        int index =0;
        for (Map.Entry<String, Integer> entry:map.entrySet()) {
			counts[index++] = entry.getValue();
		}
        Arrays.sort(counts);
        if (size>8) {
			for (int i = size-1; i >=size-8; i--) {
				for (int j = 0; j < names.size(); j++) {
					if (map.get(names.get(j))==counts[i]) {
						System.out.println(names.get(j)+" "+counts[i]);
						names.remove(j);
						break;
					}
				}
			}
		}else {
			for (int i = size-1; i>=0; i--) {
				for (int j = 0; j < names.size(); j++) {
					if (map.get(names.get(j))==counts[i]) {
						System.out.println(names.get(j)+" "+counts[i]);
						names.remove(j);
						break;
					}
				}
			}
		}
	}

}
