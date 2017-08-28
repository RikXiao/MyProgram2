package LeetCode;

public class 分糖果 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] a = {2,1};
System.out.println(candy(a));
	}
	public static int candy(int[] ratting){
		int length = ratting.length;
		if (length<=1) {
			return length;
		}
		int[] result1 = new int[length];
		int[] result2 = new int[length];
		result1[0] = 1;
		result2[length-1] = 1;
		for (int i = 1; i <length; i++) {
			if (ratting[i]>ratting[i-1]) {
				result1[i]=result1[i-1]+1;
			}else {
				result1[i]= 1;
			}
		}
		
		for (int i = length-2; i >=0; i--) {
			if (ratting[i]>ratting[i+1]) {
				result2[i] = result2[i+1]+1;
			}else {
				result2[i] = 1;
			}
		}
		int[] result = new int[length];
		int sum=0;
		for (int i = 0; i < result.length; i++) {
			result[i] = Math.max(result1[i], result2[i]);
			sum+=result[i];
		}
		return sum;
	}

}
