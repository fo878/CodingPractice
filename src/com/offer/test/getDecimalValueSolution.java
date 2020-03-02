package com.offer.test;
import com.offer.datastructure.ListNode;
/**
 *给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值
 */

public class getDecimalValueSolution{
    public int getDecimalValue(ListNode head) {
        StringBuffer s = new StringBuffer();
        while (head.next!=null){
            s.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(s.toString(),2);
    }
}


