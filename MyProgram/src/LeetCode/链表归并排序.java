package LeetCode;


public class 链表归并排序 {
	
	 public ListNode sortList(ListNode head) {
	     if (head==null||head.next==null) {
			return head;
		}
		 ListNode  middle = findMiddle(head); 
		 ListNode head1= sortList(middle.next);
		 middle.next=null;// 注意前一半链表尾结点的next置NULL，这样才能在归并时知道终点
		 ListNode head2 = sortList(head);
		 
		return merge(head1,head2);
	 }
	 public ListNode findMiddle(ListNode head){
		 ListNode fast,low;//快慢指针找到链表中心
		 low = head;
		 fast = head.next;
		 while(fast!=null&&fast.next!=null){
			 fast= fast.next.next;
			 low = low.next;
		 }
		 return low;
	 }
	 
	 public ListNode merge(ListNode head1,ListNode head2){
		 if (head1==null) {
			return head2;
		}
		 if (head2==null) {
			return head1;
		}
		 ListNode head = new ListNode(0);//头部指针不能改变
		 ListNode p = head;//指向尾部的指针
		 while(head1!=null&&head2!=null){
			 if (head1.val<head2.val) {
				p.next=head1;
				head1=head1.next;
			}else {
				p.next=head2;
				head2=head2.next;
			}
			 p=p.next;
		 }
		 //当其中一个结束后，将另一个全部接到p后面
		 if (head1!=null) {
			p.next=head1;
		}if (head2!=null) {
			p.next = head2;
		}
		return head.next;
	 }
}
