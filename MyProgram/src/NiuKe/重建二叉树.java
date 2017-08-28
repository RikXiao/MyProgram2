package NiuKe;

import java.util.Arrays;
import java.util.Scanner;

public class 重建二叉树 {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	int length = pre.length;
    	if (length==0) {
			return null;
		}
        int rootVal = pre[0];        
        TreeNode head = new TreeNode(rootVal);        
        if(length==1){
            return head;
        }
        int[] leftPre =null;//使用了大量的数组复制，若使用下标，可以节约很多空间速率也会有一定程度的提升，但是时间复杂度是基本相同的
        int[] rightPre =null;
        int[] leftIn = null;
        int[] rightIn =null;
        for(int i=0;i<length;i++){
            if(rootVal==in[i]){
                leftIn = Arrays.copyOfRange(in,0,i);
                leftPre = Arrays.copyOfRange(pre,1,i+1);
                rightIn = Arrays.copyOfRange(in,i+1,length);
                rightPre = Arrays.copyOfRange(pre,i+1,length);
                break;
            }
        }
        TreeNode leftNode = reConstructBinaryTree(leftPre,leftIn);
        TreeNode rightNode = reConstructBinaryTree(rightPre,rightIn);
        head.left = leftNode;
        head.right = rightNode;
        return head;
        
    }
}
