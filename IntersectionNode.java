public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = 0, lenB = 0;
    ListNode p = headA, q = headB;
    while (p != null) {
        lenA++;
        p = p.next;
    }
    while (q != null) {
        lenB++;
        q = q.next;
    }
    int diff = Math.abs(lenA - lenB);
    while (diff > 0) {
        if (lenA > lenB) {
            headA = headA.next;
        } else {
            headB = headB.next;
        }
        diff--;
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