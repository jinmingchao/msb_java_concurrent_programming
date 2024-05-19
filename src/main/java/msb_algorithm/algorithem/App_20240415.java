package msb_algorithm.algorithem;

/**
 * 86.分隔链表
 */
public class App_20240415 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode moreThanXHead = null, lessThanXHead = null;
        ListNode cur = head, tmpHead_1 = null, tmpHead_2 = null;
        while (cur != null) {
            ListNode tmp = new ListNode(cur.val);
            if(cur.val < x) {
                if (lessThanXHead == null) {
                    tmpHead_1 = lessThanXHead = tmp;
                } else {
                    lessThanXHead.next = tmp;
                    lessThanXHead = lessThanXHead.next;
                }
            } else {
                if(moreThanXHead == null) {
                    tmpHead_2 = moreThanXHead = tmp;
                } else {
                    moreThanXHead.next = tmp;
                    moreThanXHead = moreThanXHead.next;
                }
            }
            cur = cur.next;
        }

        if(lessThanXHead == null ) return head;
        lessThanXHead.next = tmpHead_2;
        return tmpHead_1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
