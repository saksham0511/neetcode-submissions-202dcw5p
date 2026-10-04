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
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        if (node == null) {
            return head.next;
        }
        ListNode dummy = head;
        while (node != null) {
            node = node.next;
            if (node == null) {
                dummy.next = dummy.next.next;
                break;
            }
            dummy = dummy.next;
        }
        return head;
    }
}
