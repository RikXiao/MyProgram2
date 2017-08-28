package LeetCode;

public class 反转链表 {

   public	ListNode reverListNode(ListNode head){
	   if(null==head|| null==head.next) return head;    //少于两个节点没有反转的必要。  
	    ListNode p;  
	    ListNode q;  
	    ListNode r;  
	    p = head;    
	    q = head.next;  
	    head.next = null; //旧的头指针是新的尾指针，next需要指向NULL  
	    while(q!=null){  
	        r = q.next; //先保留下一个step要处理的指针  
	        q.next = p; //然后p q交替工作进行反向  
	        p = q;   
	        q = r;   
	    }  
	    head=p; // 最后q必然指向NULL，所以返回了p作为新的头指针  
	    return head;  
   } 
}
