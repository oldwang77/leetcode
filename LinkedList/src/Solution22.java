/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 双指针问题
        if (head == null) return null;
        ListNode beforeNode = head;
        ListNode backNode = head;
        k--;
        while (k > 0) {
            backNode = backNode.next;
            k--;
        }
        while (backNode.next != null) {
            beforeNode = beforeNode.next;
            backNode = backNode.next;
        }
        return beforeNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

    }
}