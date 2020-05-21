package com.leetcode.DataStructure.list;
/*
* 25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class reverseKGroupSolution {
    public ListNode reverseKGroup(ListNode head,int k){
        if (head==null) return null;
        ListNode cur = head;
        int i = k;
        while(i>0 && cur!=null){
            cur = cur.next;
            i--;
        }
        if (i>0) return head;

        ListNode pre = reverseKGroup(cur,k);
        cur = head;
        i = k;
        while(i>0){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            i--;
        }
        return pre;
    }
}
