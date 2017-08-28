package HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 扑克牌24点运算 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String[] arr = new String[4];
			int flag = 0;
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < 4; i++) {
				arr[i] = in.next();
				
				if (arr[i].toUpperCase().equals("JOKER")) {
					flag = 1;
				}else if(arr[i].equals("J")) {
					arr[i]="11";
					map.put(arr[i], "J");
				}else if (arr[i].equals("Q")) {
					arr[i]="12";
					map.put(arr[i], "Q");
				}else if (arr[i].equals("K")) {
					arr[i]="13";
					map.put(arr[i], "K");
				}else if (arr[i].equals("A")) {
					arr[i]="1";
					map.put(arr[i], "A");
				}
				else if (arr[i].equals("2")||arr[i].equals("3")||
						arr[i].equals("4")||arr[i].equals("5")||arr[i].equals("6")
						||arr[i].equals("7")||arr[i].equals("8")||arr[i].equals("9")
						||arr[i].equals("10")||arr[i].equals("1")) {
					map.put(arr[i], arr[i]);
				}else {
					flag=2;
				}
			}
			
			if (flag==0) {
				int[] data = new int[4];
				for (int i = 0; i < arr.length; i++) {
					data[i] = Integer.valueOf(arr[i]);
				}
				Stack<String> result = new Stack<>();
				boolean[] flags = new boolean[4];
				if (find24(data, result, flags,0,4)) {
					StringBuilder a =new StringBuilder();
					while (!result.isEmpty()) {
						String s = result.pop();
						String s1 = map.get(s);
						if (s1!=null) {
							a.append(s1);
						}else {
							a.append(s);
						}
					}
                    System.out.println(a.reverse());
				}else {
					System.out.println("NONE");
				}
			}else if (flag==1) {
				System.out.println("ERROR");
			} else {
				System.out.println("NONE");
			}
		}

	}
	
	public static boolean find24(int[] arr,Stack<String> result,boolean[] flag,float total,int length){
		if (length==0) {
			//System.out.println(total);
			return total==24;
		}
		if (length==4) {
			for (int i = 0; i < flag.length; i++) {
				total=arr[i];
				flag[i]=true;
				result.push(arr[i]+"");
				if (find24(arr, result, flag, total, length-1)) {
					return  true;
				}else {
					result.pop();
					flag[i] =false;
				}
			}
			return false;
		}
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]==false) {
				int a = arr[i];				
				flag[i]=true;
				//减
				float total2=total-a;
				result.push("-");
				result.push(a+"");
				if (find24(arr, result, flag, total2, length-1)) {
					return true;
				}
				result.pop();
				result.pop();
				//加
				float total1=total+a;
				result.push("+");
				result.push(a+"");
				if (find24(arr, result, flag, total1, length-1)) {
					return true;
				}				
				result.pop();
				result.pop();
			
				//乘
				float total3 = total*a;
				result.push("*");
				result.push(a+"");
				if (find24(arr, result, flag, total3, length-1)) {
					return true;
				}
				result.pop();
				result.pop();
				//除 因为除的存在所以不能使用int 除法，要带小数才行
				if (a!=0) {
					float total4 = total/a;
					result.push("/");
					result.push(a+"");
					if (find24(arr, result, flag, total4, length-1)) {
						return true;
					}
					result.pop();
					result.pop();
				}
			
				flag[i] = false;
			}
		}
		return false;
	}

}
