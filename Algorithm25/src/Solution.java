/**
 * Created by linfeng on 20/03/2017.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (null == tail) {
                return head;
            } else {
                tail = tail.next;
            }
        }
        tail = reverseKGroup(tail, k);

        ListNode tmp = head;
        head.next = tail;
        while (tmp != tail) {
            ListNode tmp2 = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = tmp2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        Solution m = new Solution();
        m.reverseKGroup(head, 2);
        System.out.println("end");
    }
}
