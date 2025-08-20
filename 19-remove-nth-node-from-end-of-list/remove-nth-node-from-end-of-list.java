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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next ==  null){
            return null;
        }

        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count += 1;
        }

        int target = count - n;
        
        if(target == 0) return head.next;

        ListNode curr = head;
        for(int i=0; i<target-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }
}