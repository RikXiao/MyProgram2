package HuaWei;

import java.util.Scanner;

public class DNA序列字串GC的比率 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String DNA = in.next();
			int length = in.nextInt();
			System.out.println(findMaxGC(DNA, length));
		}

	}
	
	public static String findMaxGC(String DNA,int length){
		int l = DNA.length();
		int max =0;
		int index=0;
		for (int i = 0; i+length <=l; i++) {
			String subString = DNA.substring(i,i+length);
			int count =0;
			for (int j = 0; j < length; j++) {
				char thec = subString.charAt(j);
				if (thec=='G'||thec=='C') {
					count++;
				}
			}
			if (count>max) {
				max=count;
				index=i;
			}
		}
		if (max==0) {
			return "无GC";
		}else {
			return DNA.substring(index,index+length);
		}
		
		
	}

}
