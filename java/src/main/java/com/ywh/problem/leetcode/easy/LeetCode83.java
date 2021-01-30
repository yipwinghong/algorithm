package com.ywh.problem.leetcode.easy;

import com.ywh.ds.list.ListNode;

/**
 * 删除排序链表中的重复元素
 * [链表]
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 *      输入: 1->1->2
 *      输出: 1->2
 * 示例 2:
 *      输入: 1->1->2->3->3
 *      输出: 1->2->3
 * 
 * @author ywh
 * @since 2/16/2019
 */
public class LeetCode83 {

    /**
     * Time: O(n), Space: O(1)
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicatesInSortedList(ListNode head) {
        if (head == null) {
            return head;
        }
        for (ListNode cur = head; cur.next != null; ) {

            //  +-------------+
            //  |             |
            // cur            ↓
            // [1] -> [1] -> [2] -> [3] -> null
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }

            //        cur => cur
            // [1] -> [1] -> [2] -> [3] -> null
            else {
                cur = cur.next;
            }
        }
        return head;
    }
}
