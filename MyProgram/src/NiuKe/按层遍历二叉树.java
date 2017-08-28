package NiuKe;

import java.util.ArrayList;

public class 按层遍历二叉树 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root==null) {
			return result;
		}
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.remove(0);
        	result.add(node.val);
        	if (node.left!=null) {
				queue.add(node.left);
			}
        	if (node.right!=null) {
				queue.add(node.right);
			}
        }
    	return result;
    }
  /*  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //使用list模拟队列，从i=0开始取每取一个i加1，而增加元素都是加在最后面
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
       if(root==null){
           return result;
       }
        list.add(root);
        result.add(root.val);
        for(int i=0;i<list.size();i++){
            TreeNode node = list.get(i);
            if(node.left!=null){
                list.add(node.left);
                result.add(node.left.val);
            }
            if(node.right!=null){
                list.add(node.right);
                result.add(node.right.val);
            }
            
        }
        return result;
    }*/
}
