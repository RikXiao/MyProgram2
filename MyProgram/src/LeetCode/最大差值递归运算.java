package LeetCode;

public class 最大差值递归运算 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int []  a = {5386,5384,11054,6345,5816,11757};
System.out.println(getDis(a));
	}
//递归求出每一个小数组的最大差值，在股票问题中可以用到
	public static int getDis(int[] A){
		int length = A.length;
		if (length==0) {
			return -1;
		}
		int [] result = new int[length];
		result[0]=0;
		int min = A[0]; //前面的所有数中最小的数
		for (int i = 1; i < result.length; i++) {
			result[i] = Math.max(A[i]-min, result[i-1]);
			//更新前面的最小值
			if (A[i]<min) {
				min= A[i];
			}
		}
		return result[length-1];
	}
}
