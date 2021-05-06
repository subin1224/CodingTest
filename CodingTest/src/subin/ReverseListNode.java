package subin;

public class ReverseListNode {
	/**
	 * Definition for singly-linked list.
	*/
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	public ListNode reverseList(ListNode head) {
        /*
        https://leetcode.com/problems/reverse-linked-list/
        LinkedList - Easy
        return reverse ListNode
        */
		
		//temp 이용하자
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode temp = curr.next; //nextTemp
			curr.next=prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
    }
}
