package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 最长的数字串 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			ArrayList<String> result = getMaxL(input, new ArrayList<String>());

			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i));
			}
			System.out.println(","+result.get(0).length());
		}

	}
	
	public static ArrayList<String> getMaxL(String input,ArrayList<String> result){
		int length = input.length();
		if (length==0) {
			result.add("");
			return result;
		}
		char[] arr = input.toCharArray();
		int i =0;
		int max =0;
		result.add("");
		while(i<length){
			if (arr[i]>='0'&&arr[i]<='9') {
				int count=1;
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append(arr[i]);
				for (int j = i+1; j < length; j++) {
					if (arr[j]>='0'&&arr[j]<='9') {
						count++;
						sBuilder.append(arr[j]);
					}else {
						break;
					}
				}
				if (count>max) {
					max=count;
					result.clear();
					result.add(sBuilder.toString());
				}
				else if (count==max) {//这个判断放在前面更好，因为前面一个会使max=count,如果不加else可能两个判断都会执行
					result.add(sBuilder.toString());
				}
				i=i+count;
			}else {
				i++;
			}
		}
		return result;
	}

}
