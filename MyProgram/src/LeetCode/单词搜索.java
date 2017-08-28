package LeetCode;

public class 单词搜索 {
//回溯法
	public boolean exist(char[][] board, String word) {
		if (word==null||word.equals("")) {
			return false;
		}
		char[] arr = word.toCharArray();
		boolean[][] flag = new boolean[board.length][board[0].length];
		for (int i = 0; i < flag.length; i++) {
			for (int j = 0; j < flag[0].length; j++) {
				if (exist(board, i, j, flag, arr, 0)) {
					return true;
				}
			}
		}
		
		return false;
		
    }
	
	public boolean exist(char[][] board,int x,int y,boolean[][] flag,char[] word,int n){
		if (n==word.length) {
			return true;
		}
		if (x>=0&&x<board.length&&y>=0&&y<board[0].length) {//下标没有超出范围
			if (flag[x][y]==false) {//该格没有使用过
				if (word[n]==board[x][y]) {
					flag[x][y]=true;
					boolean result = exist(board, x+1, y, flag, word, n+1)
							       ||exist(board, x-1, y, flag, word, n+1)
							       ||exist(board, x, y+1, flag, word, n+1)
							       ||exist(board, x, y-1, flag, word, n+1);
					if (result==false) {
						flag[x][y]=false;
					}
					return result;
				}
				
			}
		}
	    return false;	
	}
}
