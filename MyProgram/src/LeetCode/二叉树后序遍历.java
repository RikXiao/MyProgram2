package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class 二叉树后序遍历 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
/*	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		traversal(root, result);
		return result;
		
	}*/
	
	public void traversal(TreeNode root,ArrayList<Integer> list){
		if (root!=null) {
			traversal(root.left, list);
			traversal(root.right, list);
			list.add(root.val);
		}
		
	}

//非递归后续遍历
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.peek();
			if (root.right == null || root.right == pre) {
				list.add(stack.pop().val);
				pre = root;
				root = null;
			} else
				root = root.right;
		}
		return list;
	}
}
