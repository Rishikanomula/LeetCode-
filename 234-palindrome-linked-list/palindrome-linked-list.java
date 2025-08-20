/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow);
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalin = true;
        while(p2!=null){
            if(p1.val != p2.val){
                isPalin = false;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return isPalin;
    }
}