package com.leetcode.DataStructure.list;
/*
* 141. 环形链表
* 判断链表中是否有环
* 快慢指针法
* */
public class hasCycleSolution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast){
            if (fast == null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}