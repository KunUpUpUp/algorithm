public ListNode reverseList(ListNode head) {
    ListNode pre = null, next = null;
    while (head != null) {
        // 下一节点
        next = head.next;
        // 当前节点
        head.next = pre;
        // 上一节点
        pre = head;
        // 迭代
        head = next;
    }
    return pre;
}