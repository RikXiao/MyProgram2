package NiuKe;

public class 打劫房屋 {
	public static void main(String[] args) {
		
	}

	public static long houseRobber(int[] A) {
        int length = A.length;
        if (length<1) {
			return 0;
		}
        long[] tmp = new long[length];
        for (int i = 0; i < tmp.length; i++) {			
				tmp[i] = -1;			
		}
		return Robber(A, 0, length-1,tmp);
    }
	public static long Robber(int[] A,int left,int lastId,long[]tmp){
		if (left >= 0 && left <=lastId) {
			if (left==lastId) {
				tmp[left]=A[left];
				return A[left];
			}
			if (tmp[left]>-1) {
				return tmp[left];
			}
			//抢劫mid与不抢mid
			long money1 = A[left]+Robber(A, left+2, lastId,tmp);
			long money2 = Robber(A, left+1, lastId,tmp);
			
			tmp[left]= Math.max(money1, money2);
			return tmp[left];
		}
		return 0;
		
	}
	public long solve(int idx,int[] nums,long[] result){
		if (idx<0) {
			return 0;
		}
		if (result[idx]>=0) {
			return result[idx];
		}
		
		result[idx] = Math.max(nums[idx]+solve(idx-2, nums,result), solve(idx-1, nums,result));
		
		return result[idx];
	}
}
