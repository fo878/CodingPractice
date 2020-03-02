package com.offer.test;

/*
* 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
* 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
* 这个链表的倒数第3个节点是值为4的节点。
*
* p指针先走k个位置，之后与q指针同步向后移动，当p指针到表尾，并指向为空时，q指针即指针目的节点。
* */

public class getKthFromEndSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p=head;
        ListNode q=head;
        while (k>1){
            p = p.next;
            k--;
        }
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
