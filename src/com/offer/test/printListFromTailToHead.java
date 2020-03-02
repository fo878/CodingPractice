package com.offer.test;

import java.util.ArrayList;
import java.util.Collections;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/*
*输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
* */
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> listNodes = new ArrayList<>();
        while (listNode != null) {
            listNodes.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(listNodes);
        return listNodes;
    }

}

