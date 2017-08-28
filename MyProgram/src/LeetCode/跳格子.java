package LeetCode;

public class 跳格子 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[]  A ={2,3,1,1,4};
        System.out.println(jump(A));
	}
	//找到当前跳得最远的格子
	public static int jump(int[] A){
		if (A==null) {
			return 0;
		}
		return jump(A, 0, 0);
	}
	public static int jump(int[] arr,int index,int count){
		if (index<arr.length-1) {
			if (arr[index]<arr.length-1-index) {
				int cap = arr[index];
				int max = cap;
				int next=index;
				for (int i = 1; i <= cap; i++) {
					int tmp =i+arr[index+i]; 
					if (tmp>max) {
						max = tmp;
						next = index+i;
					}
				}
				count++;
			return	jump(arr, next, count);
			}else {
				return ++count;
			}
		}else {
			return count;
		}
		
	}

}
