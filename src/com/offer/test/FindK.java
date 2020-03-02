package com.offer.test;

/*
* 输入一个链表，输出该链表中倒数第k个结点。
* */
import java.util.ArrayList;
import com.offer.datastructure.ListNode;

public class FindK {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(k == 0){
            return null;
        }
        int count=0;
        ListNode ans = null;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while(head != null){
            count++;
            list.add(head);
            head = head.next;
        }
        if(count>=k){
            return list.get(count-k);
        }
        else{
            return null;
        }
    }



    public static void main(String[] args) {

    }
}
