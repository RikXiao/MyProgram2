package LeetCode;

import java.util.Arrays;

public class 买股票最大差值 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int [] data = {10,7,3,1};
        System.out.println(calculateMax1(data));
	}


	/*public int calculateMax1(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length < 2
				|| prices.length > 100) {
			return 0;
		}

		int len = prices.length;
		int[] dpl = new int[len];
		dpl[0] = 0;
		int minI = 0;
		for (int i = 1; i < len; i++) {// 从左到右扫描一遍填充dpl数组
			if (prices[i] > prices[i - 1]) {
				dpl[i] = Math.max(prices[i] - prices[minI], dpl[i - 1]);
			} else {
				dpl[i] = dpl[i - 1];
				if (prices[i] < prices[minI])
					minI = i;
			}
		}
		int[] dpr = new int[len];
		dpr[len - 1] = 0;
		int maxI = len - 1;
		for (int i = len - 2; i >= 0; i--) {// 从右到左扫描一遍填充dpr数组
			if (prices[i] < prices[i + 1]) {
				dpr[i] = Math.max(prices[maxI] - prices[i], dpr[i + 1]);
			} else {
				dpr[i] = dpr[i + 1];
				if (prices[i] > prices[maxI]) {
					maxI = i;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < len; i++) { // 比较得出最大值
			res = Math.max(dpl[i] + dpr[i], res);
		}
		return res;
	}*/
	
	
	 public static int calculateMax1(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length < 2
				|| prices.length > 100) {
			return 0;
		}

		int len = prices.length;
		int[] dpl = new int[len];
		dpl[0] = 0;
		int minI = prices[0];
		for (int i = 1; i < len; i++) {// 从左到右扫描一遍填充dpl数组
			dpl[i] = Math.max(prices[i]-minI, dpl[i-1]);
			if (prices[i]<minI) {
				minI=prices[i];
			}
		}
		int[] dpr = new int[len];
		dpr[len - 1] = 0;
		int maxI = prices[len-1];
		for (int i = len - 2; i >= 0; i--) {// 从右到左扫描一遍填充dpr数组
			dpr[i] = Math.max(maxI-prices[i], dpr[i+1]);
			if (prices[i]>maxI) {
				maxI=prices[i];
			}
		}

		int res = 0;
		for (int i = 0; i < len; i++) { // 比较得出最大值
			res = Math.max(dpl[i] + dpr[i], res);
		}
		return res;
	}

	public int calculateMax(int[] prices) {
		int firstBuy = Integer.MIN_VALUE, firstSell = 0;
		int secondBuy = Integer.MIN_VALUE, secondSell = 0;

		for (int curPrice : prices) {
			firstBuy = Math.max(firstBuy, -curPrice);
			firstSell = Math.max(firstSell, firstBuy + curPrice);
			secondBuy = Math.max(secondBuy, firstSell - curPrice);
			secondSell = Math.max(secondSell, secondBuy + curPrice);
		}
		return secondSell;
	}
}
