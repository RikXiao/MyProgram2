package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 数分组 {

	/**
	 * @param args
	 */
	public static ArrayList<Integer> list = new ArrayList<>();
	public static double min = 10000000;
	public static int halfS = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int len = in.nextInt();
			min = 10000000;
			list.clear();
			int[] arr = new int[len];
			int sum = 0;
			for (int i = 0; i < len; i++) {
				arr[i] = in.nextInt();
				sum+=arr[i];
			}
			combine(arr, len/2, len, sum/2);
			System.out.println(Math.abs(sum-2*halfS));
		}

	}
	
	public static int combine(int[] data,int r,int n,double half){
		if (r>n) {			
			return 0;
		}
		if (r==0) {
			int sum =0;
			for (int i = 0; i < list.size(); i++) {
				sum+=list.get(i);
			}
			double abs = Math.abs(sum-half);
			if (abs<min) {
				min = abs;
				halfS = sum;
			}
			return 1;
		}
		//拿第n个
		list.add(data[n-1]);
		int tmp1 = combine(data, r-1, n-1,half);
		list.remove(list.size()-1);
		//不拿第n个
		int tmp2 = combine(data, r, n-1,half);
		return tmp1+tmp2;
		
	}

}
