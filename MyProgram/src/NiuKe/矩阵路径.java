package NiuKe;

public class 矩阵路径 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	        if(matrix==null||rows<1||cols<1||str==null||matrix.length==0||str.length==0){
	            return false;
	        }
	        boolean [] flagArr = new boolean[rows*cols];
	        
	        int pathIndex=0;
	        for(int row = 0;row<rows;row++){
	            for(int col = 0;col<cols;col++){
	                if(findPath(matrix, rows, cols, str,pathIndex,row,col,flagArr)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    
	    }

	  public boolean findPath(char[] matrix, int rows, int cols, char[] str,int pathIndex,int row,int col,boolean[] flagArr){
	      if(pathIndex==str.length){
	          return true;
	      }
	     
	      if(row<rows&&row>=0&&col>=0&&col<cols&&matrix[row*cols+col]==str[pathIndex]&&flagArr[row*cols+col]==false){
	          pathIndex++;
	          flagArr[row*cols+col]=true;
	          boolean result = findPath(matrix, rows, cols, str,pathIndex,row-1,col,flagArr)||
	                           findPath(matrix, rows, cols, str,pathIndex,row+1,col,flagArr)||
	                           findPath(matrix, rows, cols, str,pathIndex,row,col-1,flagArr)||
	                           findPath(matrix, rows, cols, str,pathIndex,row,col+1,flagArr);
	          if(!result) {//如果在下一个没有找到正确的路径，则要将当前步往回退（即当前这个标志已经访问过的节点要重新标记为没有访问过）      
	              flagArr[row*cols+col]=false;
	          }
	          return result;
	          
	      }else{
	          return false;
	      }
	      
	  }
}
