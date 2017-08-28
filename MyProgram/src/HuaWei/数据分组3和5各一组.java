package HuaWei;

import java.util.Scanner;

public class 数据分组3和5各一组 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int[] data = new int[num];
			int sum=0;
			int sum3 = 0;
			int sum5 = 0;
			
			boolean[] flag = new boolean[num];
			for (int i = 0; i < num; i++) {
				int a = in.nextInt();
				data[i]=a;
				sum+=a;
				if (a%5==0) {
					sum5+=a;
					flag[i]=true;
				}else if (a%3==0) {
					sum3+=a;
					flag[i]=true;
				}
			}
			System.out.println(sum);
			//System.out.println(isDivision(data, 0, flag, sum3, sum5));
			System.out.println(fillLeft(data, flag, sum, sum5));
		}
	}
	//递归法，先把3和5的倍数分组，然后在通过递归把剩下的数分别给两组，看是否有符合条件的；(有负数不可以使用背包问题)
	public static boolean isDivision(int[] data,int index,boolean[] flag,int sum3,int sum5){
		if (index==data.length) {
			return sum3==sum5;
		}
		if (flag[index]==false) {
			flag[index]=true;
			boolean result = isDivision(data, index+1, flag, sum3+data[index], sum5)||isDivision(data, index+1, flag, sum3, sum5+data[index]);
			flag[index]=false;
			return result;
		}else {//跳过该数字，转下一个
			return isDivision(data, index+1, flag, sum3, sum5);
		}
	}
	//将其化为背包问题，总共和sum,3和5分组后，看下与sum/2比较sum3或sum5还剩下多少空间，将剩下的空间装满
	public static boolean fillLeft(int[] data,boolean[] flag,int sum,int sum5){
		if (sum%2!=0) {
			return false;
		}
		int left = sum/2-sum5;
		int num=0;
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]==false) {
				num++;
			}
		}
		int[] arr = new int[num];
		int index =0;
		for (int i = 0; i < arr.length; i++) {
			if (flag[i]==false) {
				arr[index++]=data[i];
			}
		}
		int[][] val = new int[num+1][left+1];
		//初始化第一行，第一列
		for (int i = 0; i <= left; i++) {
			val[0][i]=0;
		}
		for (int i = 0; i <= num; i++) {
			val[i][0]=0;
		}
		System.out.println(left);
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= left; j++) {
				//第i个数能不能够被放进去
				if (arr[i-1]<=j) {//能放进去
					val[i][j]=Math.max(arr[i-1]+val[i-1][j-arr[i-1]], val[i-1][j]);
					if (val[i][j]==left) {
						return true;
					}
				}else {//不能放进去，那就是前面i-1个中最大的
					val[i][j]=val[i-1][j];
					if (val[i][j]==left) {
						return true;
					}
				}
				
			}
		}
		
		return false;
	}
}
