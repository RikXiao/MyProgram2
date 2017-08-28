package NiuKe;

public class 二维数组查找 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public boolean Find(int target ,int [][] array) {
	        int len = array.length-1;
	        int i = 0;
	        while((len >= 0)&& (i < array[0].length)){
	            if(array[len][i] > target){
	                len--;
	            }else if(array[len][i] < target){
	                i++;
	            }else{
	                return true;
	            }
	        }
	        return false;
	    }
}
