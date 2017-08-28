package LeetCode;

public class 升序链表转平衡查找树 {
	
	    public TreeNode sortedListToBST(ListNode head) {
	        if(head==null){	        	
	            return null;
	        }
	        if (head.next == null) {
				TreeNode root = new TreeNode(head.val);
				return root;
			}
	        ListNode pre = new ListNode(0);
	        pre.next = head;
	        ListNode slow = head;
	        ListNode fast = head.next.next;//找到中间的前面一个节点
	        while(fast!=null&&fast.next!=null){
	        	slow = slow.next;
	        	fast = fast.next.next;
	        }//slow最后指向中间的前面一个节点,所以slow.next不可能为null,slow.next为当前根节点
	       
	        ListNode head2 = slow.next.next;
	        TreeNode root = new TreeNode(slow.next.val);
	        slow.next = null;
	        root.left = sortedListToBST(head);
	        root.right = sortedListToBST(head2);
	        return root;
	    }
	
}
