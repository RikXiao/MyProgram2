package LeetCode;

  //Definition for binary tree

 
import java.util.*;
public class 二叉树最小深度 {
	  
    public int depth = 0;
    public ArrayList<Integer> list = new ArrayList<>();
    public int run(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return 1+run(root.right);
        }
        if(root.right==null){
            return 1+run(root.left);
        }
        return Math.min(run(root.left)+1,run(root.right)+1);
        
        
    }
    public static void main(String[] args) {
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		node1.left = node2;
		node1.right = node3;
	}
 /*  public void get1(TreeNode root) {//使用这个方法，在没完成一个用例，需要清空list
        if(root!=null){
            depth++;
             if(root.left==null&&root.right==null){
	                list.add(depth);                              
	            }else{
	                get1(root.left);
	                get1(root.right);                
	            }
            depth--;            
        }
    }*/
 
}