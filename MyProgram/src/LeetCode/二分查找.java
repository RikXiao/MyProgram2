package LeetCode;

public class 二分查找 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	}
	 public int get2pos(int[] A,int left,int right,int val){
		 if (left>=0&&right<A.length&&left<=right) {
				
	        int midlle = (left+right)/2;
	        
	        if(val>A[midlle]){
	            return get2pos(A,midlle+1,right,val);
	        }
	        if(val<A[midlle]){
	            return get2pos(A,left,midlle-1,val);
	        }
	        if ((midlle>0)&&A[midlle-1]==val) {
				return get2pos(A, left, midlle-1, val);
			}
	        return midlle;
	    }
		else{
			return -1;
		}
		 }
}
