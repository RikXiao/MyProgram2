package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

public class 区间合并 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			String[] arr = str.split(",");
			boolean[] result = new boolean[65535];
			int length = arr.length;
			for (int i = 0; i <length; i++) {
				String[] next= arr[i].split("-");
				if (next.length==1) {
					int index =Integer.valueOf(next[0]);
					result[index]=true;
				}else {
					int begin = Integer.valueOf(next[0]);
					int end = Integer.valueOf(next[1]);
					for (int j = begin; j <=end; j++) {
						result[j] = true;
					}
				}
			}
			int start = -1;
			int end = -1;
			boolean isStart = false;
			ArrayList<String> out = new ArrayList<>();
			for (int i = 0; i < result.length; i++) {
				if (result[i] == true) {
					if (!isStart) {
						start = i;
						isStart = true;
					}else {
						end = i;
					}
				}else {
					if (isStart) {
						if (end!=-1) {
							out.add(start+"-"+end);							
						}else {
							out.add(start+"");
						}
						start = -1;
						end = -1;
						isStart = false;
					}
				}
			}
			int size = out.size();
			for (int i = 0; i < size-1; i++) {
				System.out.print(out.get(i)+",");
			}
			System.out.println(out.get(size-1));
		}

	}

}
