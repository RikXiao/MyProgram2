package HuaWei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 称砝码 {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int Num = in.nextInt();
			int weight[] = new int[Num];
			int count[] = new int[Num];
			for (int i = 0; i < Num; i++) {
				weight[i]=in.nextInt();
			}
			for (int i = 0; i < Num; i++) {
				count[i]=in.nextInt();
			}
			int totalNum = fama(Num, weight, count);
			System.out.println(totalNum);
		}

	}
	
	public static int fama(int n,int[] weight,int[] count){
		//设Q[i]，表示前i种砝码共有这么多种不同的重量，那么Q[i]=Q[i-1]+k*weight[i]
		//weight[i]表示第i种砝码的重量，k是个数；
		Set<Integer> qualitySet = new HashSet<>();
		for(int i=0;i<n;i++){
			Set<Integer> tmpSet = new HashSet<>();
			if (qualitySet.isEmpty()) {//最开始Q[i]=0;
				for(int j=0;j<=count[i];j++){
					tmpSet.add(j*weight[i]);
				}
			}
			else {
				for (Integer Qi : qualitySet) {//对每一个Qi，都循环加一遍k*weight[i];
					for (int j = 0; j <= count[i]; j++) {
						tmpSet.add(Qi+j*weight[i]);
					}
				}
			}
			qualitySet =tmpSet;
		}
		int total = qualitySet.size();
		return total;
	}

}
