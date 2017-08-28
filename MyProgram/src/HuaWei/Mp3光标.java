package HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mp3光标 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int count = in.nextInt();
			String order = in.next();
			List<Integer> result = findPlaces(count, 1, 4, order);
			int length = result.size();
			for (int i = 0; i < length-1; i++) {
				if (i==length-2) {
					System.out.println(result.get(i));
				}else {
					System.out.print(result.get(i)+" ");
				}
			}
			System.out.println(result.get(length-1));
		}

	}
	
	public static ArrayList<Integer> findPlaces(int count,int start,int end,String order){
		char[] arr = order.toCharArray();
		int index=1;
		ArrayList<Integer> list = new ArrayList<>();
	/*	if (count<=4) {
			for (int i = 1; i <= count; i++) {
				list.add(i);
			}
		}*/
		for (int i = 0; i < arr.length; i++) {
			char thec = arr[i];
			if (thec=='U') {//上移命令处理
				if (index==1) {
					index=count;//光标移动
					if (count>4) {//判断是否需要翻页
						end=count;
						start=count-3;
					}
				}else {					
					if (index==start) {//上移时若光标不在1,并且当前页第一行
						start--;
						end--;
					}
					index=index-1;
				}
			}
			//下移命令处理
			if(thec=='D'){
				if (index==count) {
					index=1;
					if (count>4) {
						start=1;
						end=4;
					}
				}else {
					if (index==end) {
						start++;
						end++;
					}
					index++;
				}
			}
		}
		if (count<=4) {
			for (int i = 1; i <= count; i++) {
				list.add(i);
			}
			
		}else {
			for (int i = start; i <=end; i++) {
				list.add(i);
			}
		}
		list.add(index);
		return list;
	}

}
