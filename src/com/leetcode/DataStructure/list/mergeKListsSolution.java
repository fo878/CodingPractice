package com.leetcode.DataStructure.list;

import java.util.Comparator;
import java.util.PriorityQueue;

//Definition for singly-linked list.
/*
* 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
* */
public class mergeKListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.val,o2.val)));
        for (ListNode l : lists) {
            if (l!=null){
                pq.add(l);
            }
        }
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            head.next = cur;
            head = head.next;
            if (cur.next!=null){
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(4);
        lists[1].next.next = new ListNode(6);

        lists[2] = new ListNode(0);
        lists[2].next = new ListNode(5);
        lists[2].next.next = new ListNode(8);

        mergeKListsSolution foo = new mergeKListsSolution();
        ListNode listNode = foo.mergeKLists(lists);
        while (listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}