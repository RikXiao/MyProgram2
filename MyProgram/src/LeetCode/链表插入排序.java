package LeetCode;

import java.awt.image.RescaleOp;

public class 链表插入排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4= new ListNode(6);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(7);
		ListNode node7 = new ListNode(8);
		node1.next= node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		ListNode result = insertionSortList(node1);
        System.out.println(Integer.MIN_VALUE);
	}


/*	public ListNode insertionSortList(ListNode head) {
		// 哑节点
		ListNode dumy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode pre = dumy;
		while (cur != null) {
			// 保存当前节点下一个节点
			ListNode next = cur.next;
			pre = dumy;
			// 寻找当前节点正确位置的一个节点
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// 将当前节点加入新链表中
			cur.next = pre.next;
			pre.next = cur;
			// 处理下一个节点
			cur = next;
		}
		return dumy.next;
	}*/
	public static ListNode insertionSortList(ListNode head){
		if (head==null||head.next==null) {
			return head;
		}
		ListNode tmp = head;
		ListNode index = head.next;
		head.next=null;
		while(index!=null){
			ListNode next = index.next;  //先保存下一个需要插入的对象
			index.next= null;  //将当前index对象取出来，让其next==null；
			tmp = head;
			//判断当前插入的是否要查到链表头
			if (index.val<=tmp.val) {
				index.next=tmp;
				head = index;
			}else {//插入链表之中
				 while(tmp!=null&&tmp.next!=null){
				    	if (index.val>tmp.val&&index.val<=tmp.next.val) {
				    		index.next= tmp.next;
							tmp.next= index;
							break;
						}
				    	tmp= tmp.next;
				    	//System.out.println(1);
				  }
				 if (tmp.next==null) {//如果遍历到了最后一个，则需要把index插入到链表最后
					tmp.next=index;
				}
			}
		   index = next; //改变index，准备插入下一个对象
		}
		return head;
	}
}
