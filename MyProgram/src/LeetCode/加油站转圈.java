package LeetCode;

public class 加油站转圈 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {5,0,9,4,3,3,9,9,1,2};
		int[] cost ={6,7,5,9,5,8,7,1,10,5};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
	        boolean flag = false;
	        int len = gas.length;
	        for (int i = 0; i < len; i++) {
				int tank = 0;  //油箱的由，初始为0；
				int index = i;  //当前处于的加油站起始加油站
				for (int j = 0; j < len; j++) {
					index = i;
					index = index+j;
					//System.out.println(index);
					if (index>=len) {
						index = index-len;
					}
					tank = tank+gas[index];
					if (tank>=cost[index]) {
						tank = tank-cost[index];
						if (j==len-1) {
							flag = true;
						}
					}else {
						break;
					}
				}
	        	if (flag==true) {
					return i;
				}
			}
	        return -1;
	}
	 public int canCom(int[] gas,int[] cost){
		 int total = 0;
		 int left = 0;
		 int index = -1;
		 for (int i = 0; i < cost.length; i++) {
			left +=(gas[i]-cost[i]);
			total+=(gas[i]-cost[i]);
			if (left <0) {  //跟那个最大子序列和的算法有点类似
				left = 0;
				index = i;
			}
		}
		 return total>=0?index+1:-1;
	 }
}
