package com.ywh.problem.leetcode.medium;

import com.ywh.ds.list.ListNode;

/**
 * 反转链表 II
 * [链表]
 * 
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 *      1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 *      输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *      输出: 1->4->3->2->5->NULL
 *
 * @author ywh
 * @since 2020/10/14/014
 */
public class LeetCode92 {

    /**
     * Time: O(n), Space: O(1)
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 左边越界，直接返回。
        if (m > n || m < 1) {
            return head;
        }

        // 记录链表的长度。
        int len = 0;
        ListNode left = null, right = null, next;

        // 定位左右边界：left ->  ...（待反转的部分）-> right
        for (ListNode cur = head; cur != null; cur = cur.next, len++) {
            if (len == m - 1) {
                left = cur;
            }
            if (len == n + 1) {
                right = cur;
            }
        }

        // 右边越界，直接返回。
        if (n > len) {
            return head;
        }

        // 从第一个节点开始反转：from = 1，由于遍历过程中 len > from - 1 == 0，所以 left == null
        //       |<-  待反转  ->|
        //      [ ] -> [ ] -> [ ] -> [ ] -> [ ] -> [ ] -> null
        //     node1  node2         right

        // 中间某段反转：
        //              |<-  待反转  ->|
        //      [ ] -> [ ] -> [ ] -> [ ] -> [ ] -> [ ] -> null
        //     left   node1  node2         right

        // 定位 node1、node2，作为反转的辅助节点，其中现在 node1 所指位置反转后会成为（反转部分的）末尾节点，因此要先修改其指向到 right，避免断链。
        ListNode node1 = left == null? head: left.next, node2 = node1.next;
        node1.next = right;

        // 反转 node2 到 right 之间：
        //
        //              |<-  待反转  ->|
        //      [ ] -> [ ]    [ ] -> [ ] -> [ ] -> [ ] -> null
        //     left   node1  node2          right
        //              |                    ↑
        //              +--------------------+
        while (node2 != right) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        //              +--------------------+
        //              ||<-  已反转  ->|     ↓
        //      [ ]    [ ] <- [ ] <- [ ]    [ ] -> [ ] -> null
        //     left                node1 right/node2
        //      |                    ↑
        //      +--------------------+
        if (left != null) {
            left.next = node1;
            return head;
        }

        //       +--------------------+
        //       ||<-  已反转  ->|     ↓
        //      [ ] <- [ ] <- [ ]    [ ] -> [ ] -> [ ] -> null
        //                  node1 right/node2
        //                (return)
        return node1;
    }

    /**
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode newHead = new ListNode(0, head), pre = newHead;
        // 找到第一个需要反转的节点的前一个节点 pre。
        for (int i = 0; pre.next != null && i < m - 1; i++, pre = pre.next);
        // 不足 m 个，直接返回。
        if (pre.next == null) {
            return head;
        }
        // 从 pre 开始，依次把后面的节点用头插法插到 p 节点的后面。
        ListNode cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = next;
        }
        return newHead.next;
    }

}
