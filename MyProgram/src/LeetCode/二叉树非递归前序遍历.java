package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树非递归前序遍历 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Queue<Integer> queue = new ArrayDeque<>();
	}
	public ArrayList<Integer> prePrint(TreeNode root){
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre=null;
		while(root!=null||stack.isEmpty()==false){
			while(root!=null){
				list.add(root.val);
				stack.push(root);
				root= root.left;
			}
			root = stack.peek();
			if (root.right==null||pre==root.right) {
				pre = stack.pop();
				root = null;				
			}else {
				root = root.right;
			}
		}
		return list;
	}

}
