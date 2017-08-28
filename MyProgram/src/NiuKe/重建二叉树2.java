package NiuKe;

public class 重建二叉树2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] pre = {1,2,3};
        int[] in = {2,1,3};
        TreeNode node = reBuildTree(pre, in);
        System.out.println(node.val);
	}
	public static TreeNode reBuildTree(int[] pre,int[] in){
		if (pre.length<=0||in.length<=0) {
			return null;
		}
		
		return reBuild(pre, in, 0, pre.length-1, 0, in.length-1);
	}
	public static TreeNode reBuild(int[] pre,int[] in,int left1,int right1,int left2,int right2){
		if (left1>right1||left2>right2) {
			return null;
		}
		int rootval = pre[left1];
		TreeNode root = new TreeNode(rootval);
		
		int indexOfRoot = 0;
		for (int i = left2; i <= right2; i++) {
			if (in[i]==rootval) {
				indexOfRoot = i;
			}
		}
		
		TreeNode leftNode = reBuild(pre, in, left1+1, left1+indexOfRoot-left2, left2, indexOfRoot-1);
		TreeNode rightNode = reBuild(pre, in, right1-(right2-indexOfRoot)+1, right1, indexOfRoot+1, right2);
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}

}
