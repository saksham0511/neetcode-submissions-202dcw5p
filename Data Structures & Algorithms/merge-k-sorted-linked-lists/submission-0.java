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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length-1);
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        ListNode node1 = mergeSort(lists, start, (start+end)/2);
        ListNode node2 = mergeSort(lists, 1+(start+end)/2, end);

        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                tail = tail.next;
                node1 = node1.next;
            } else {
                tail.next = node2;
                tail = tail.next;
                node2 = node2.next;
            }
        }
        if (node1 == null) {
            tail.next = node2;
        } else {
            tail.next = node1;
        }
        return head.next;
    }
}
