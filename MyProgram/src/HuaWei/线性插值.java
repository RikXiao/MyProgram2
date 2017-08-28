package HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 线性插值 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			int[][] vals = new  int[m][2];
			for (int i = 0; i < m; i++) {
				vals[i][0]=in.nextInt();
				vals[i][1]=in.nextInt();
			}
			List<String> list = process(vals);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

	}
	
	public static ArrayList<String> process(int[][] vals){
		ArrayList<String> list = new ArrayList<>();
		int index = vals[0][0];
		int val = vals[0][1];
		list.add(index+" "+val);
		for (int i = 1; i < vals.length; i++) {
		    if (vals[i][0]-index>=1) {
				fillVal(list, index, vals[i][0], val, vals[i][1]);
				index=vals[i][0];
				val = vals[i][1];
				list.add(index+" "+val);
			}
			else if(vals[i][0]-index<0) {
				list.add(vals[i][0]+" "+vals[i][1]);
				index=vals[i][0];
				val = vals[i][1];
			}else {
				continue;
			}
		}
		return list;
	}
	public static void fillVal(ArrayList<String> list,int start,int end,int startVal,int endVal){
		
		for (int i = 1; i <end-start; i++) {
			list.add((start+i)+" "+(startVal+((endVal-startVal)/(end-start))*i));
		}
	}

}
