package NiuKe;

public class 连续子数组最大和 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getFindGreatestSumOfSubArray(int[] array){
		int len = array.length;
		int max =array[0];
		int thisSum = 0;
		for (int i = 0; i < len; i++) {
			thisSum+=array[i];
			if (thisSum<0) {
				thisSum=0;
			}
			if (thisSum>max) {
				max = thisSum;
			}
		}
		return max;
	}
}
