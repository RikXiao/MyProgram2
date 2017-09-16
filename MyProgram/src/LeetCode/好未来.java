package LeetCode;

public class 好未来 {

	
	public int list_length(ListNode head){
		if (head==null) {
			return 0;
		}
		int count = 1;
		ListNode first = head;
		while(head.next!=first){
			count++;
		}
		return count;
	}
}
