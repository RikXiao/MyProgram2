package HuaWei;

import java.util.Scanner;

public class 购物单 {
	public static void main(String[] args) {		
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
            int money = in.nextInt();
			int num = in.nextInt();
			int[] weight = new int[num + 1];
			int[] value = new int[num + 1];
			int[] attch = new int[num + 1];
			
			int[][] v = new int[num + 1][money+1];
			for (int i = 1; i <= num; i++) {
				weight[i] = in.nextInt();
				value[i] = weight[i]*in.nextInt();
				attch[i] = in.nextInt();
			}
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= money; j++) {
					if (j<weight[i]) {
						//v[i][j]=v[i-1][j];
					}else {
						if (attch[i]==0) {//如果是主件,则可以购买，使用max公式求最大价值
							v[i][j] = max(v[i-1][j],value[i]+v[i-1][j-weight[i]]);
						}else {//如果是附件，则先要判断其主件是否已经在购买的前i个物品以内
							if (attch[i]>i||weight[i]+weight[attch[i]]>money) {//主件不在前i个物品之内，则该物品不可购买
								v[i][j]=v[i-1][j];
							}else {//主件在前i个物品以内，且可以购买
								//如果不买第i个物品
								int a = v[i-1][j];
								//如果购买第i个物品时，主件必须购买
								int b = value[i]+weight[attch[i]]*value[attch[i]]+v[i-1][j-weight[i]-weight[attch[i]]];
								v[i][j]=max(a,b);
							} 
						}
					}

				}

			}
			System.out.println(v[num][money]);
		}
	    in.close();	
	}
	public static int max(int a,int b){
		if (a>b) {
			return a;
		}else {
			return b;
		}
	}
}
