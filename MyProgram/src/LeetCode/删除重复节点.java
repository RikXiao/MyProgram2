package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class 删除重复节点 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node.next = node2;
		ListNode head = deleteDuplicates(node);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}

	}
	  public static ListNode deleteDuplicates(ListNode head) {
	        if(head==null) return null;
	        ListNode FakeHead=new ListNode(0);
	        FakeHead.next=head;	        
	        ListNode cur=head;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        while(cur!=null){
	        	Integer num = map.get(cur.val);
	        	if (num==null) {
					map.put(cur.val, 1);
				}else {
					map.put(cur.val, num+1);
				}
	        	cur = cur.next;
	        }
	        cur = FakeHead;
	        while(cur!=null&&cur.next!=null){
	        	Integer count = map.get(cur.next.val);
	        	if (count>1) {
					cur.next = cur.next.next;
				}else {
					cur = cur.next;
				}
	        	
	        }
	        
	        return FakeHead.next;
	    }
	
}
