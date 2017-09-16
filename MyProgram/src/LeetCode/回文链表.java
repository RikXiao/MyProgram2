package LeetCode;

import java.util.ArrayList;

public class 回文链表 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public boolean isHuiWen(ListNode head){
		ArrayList<ListNode> list =new ArrayList<ListNode>();
		while(head!=null){
			list.add(head);
			head = head.next;
		}
		int size = list.size();
		boolean result = true;
		for (int i = 0,j=size-1; i < j; i++,j--) {
			if (list.get(i).val!=list.get(j).val) {
				result = false;
			}
		}
		return result;
	}
	
	

}

 class task implements Runnable{
    int[][] A;
    int[][] B;
    int[][] result;
	int row;
	int col;	
	public task(int[][] A,int[][] B,int row,int col,int[][] result){
		this.A = A;
		this.B = B;
		this.result = result;
		this.row = row;
		this.col = col;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		juZhenChen(A, B, row, col, result);
	}
	public void juZhenChen(int[][] A,int[][] B,int row,int col,int[][] result){
		
			int sum = 0;
			for (int j = 0; j < result[0].length; j++) {
				sum+=A[row][j]*B[j][col];
			}
			result[row][col] = sum;
		
	}
	
}
