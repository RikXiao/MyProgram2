package NiuKe;

import java.util.ArrayList;

public class n以为的素数 {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = findOdd(1);
		System.out.println(list.toString());
	}
	//都要从2开始，1既不是质数也不是合数
	public static ArrayList<Integer> findOdd(int n){
		ArrayList<Integer> result = new ArrayList<>();
		if (n<=2) {
			for (int i = 2; i <= n; i++) {//从2开始，
				result.add(i);
			}
			return result;
		}
		boolean[] flag = new boolean[n+1];
		for (int i = 0; i < flag.length; i++) {
			if (i%2==0) {
				flag[i] = false;
			}else {
				flag[i] = true;
			}
		}
		flag[2] = true;//2除外
		for (int i = 3; i <=Math.sqrt(n); i+=2) {//每次加2，因为以偶数位肯定被2整除，不要再处理
			if (flag[i] == true) {
				for (int j = i+i; j <=n; j+=i) {
					flag[j] = false; //将前面质数的倍数全部设为false，因为他们肯定是合数
				}
			}
		}
		//将为true的下标全部输出
		for (int i = 2; i < flag.length; i++) {
			if (flag[i]) {
				result.add(i);
			}
		}
		return result;
	}

}
