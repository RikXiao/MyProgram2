package NiuKe;


public class 素数组合 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(count(10));
	}
	
	public static int count(int n){
		if (n<4) {
			return 0;
		}
		int[] result = new int[n];//存放一个小于n的数由两个素数组成的话，有多少种可能
		for (int i = 4; i < n; i++) {
			int sum =0;
			for (int j = 2; j < i; j++) {
				if (is(j)&&is(i-j)) {
					sum++;
				}
			}
			result[i] = sum;
		}
		//计算n由三个质数组成有多少可能
		int out = 0;
		for (int i = 2; i < n; i++) {
			if (is(i)) {
				out+=result[n-i];
			}
		}
		return out;
	}

	public static boolean is(int num){
		if (num>=2) {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num%i==0) {
					return false;
				}
			}
			return true;
		}
		return false;
		
	}
}
