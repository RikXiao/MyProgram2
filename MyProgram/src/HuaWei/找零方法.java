package HuaWei;

public class 找零方法 {

	public static int coins[] ={0,1,5,10,50,100,200,500,1000};//添加一个0，也可以不添加，程序中注意处理就好
	public int findWay(int count){
		if (count<=0) {
			return -1;
		}
		int[][] result = new int[coins.length][count+1];
		//初始化
		for (int i = 0; i <= count; i++) {
			result[0][i]=0;
		}
		for (int i = 1; i <= coins.length-1; i++) {
			result[i][0]=1;
		}
		//开始动态规划求解
		for (int i = 1; i <=coins.length-1; i++) {
			for (int j = 1; j <= count; j++) {
				result[i][j] = result[i-1][j]+result[i][j-coins[i]];
			}
		}		
		return result[coins.length-1][count];
	}
}
