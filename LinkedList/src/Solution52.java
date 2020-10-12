import java.util.ArrayList;
import java.util.HashMap;

public class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 重合的那个结点，不仅仅是要求数值相同，还需要指针相同
        // 这个题目类似是一个追及问题
        if (headA == null || headB == null) return null;
        int lena = 0, lenb = 0;
        ListNode nodea = headA, nodeb = headB;
        while (nodea != null) {
            nodea = nodea.next;
            lena++;
        }
        while (nodeb != null) {
            nodeb = nodeb.next;
            lenb++;
        }
        // 总让lena>lenb
        // 这里不能交换，大坑，交换了以后存储的地址就变了，后面肯定就不同了
        // if(lenb>lena){
        //     ListNode t = null;
        //     t = nodea;
        //     nodea = nodeb;
        //     nodeb = t;
        //     int tmp = 0;
        //     tmp = lena;
        //     lena = lenb;
        //     lenb = tmp;
        // }
        int cnt = 0;
        if (lena > lenb) {
            cnt = lena - lenb;
            // 追及问题，让A和B在同一个起跑线上
            while (cnt > 0) {
                headA = headA.next;
                cnt--;
            }
        } else {
            cnt = lenb - lena;
            while (cnt > 0) {
                headB = headB.next;
                cnt--;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(8);
        node4.next = node5;

        Solution52 s = new Solution52();
        System.out.println(s.getIntersectionNode(node1, node4));
    }
}
