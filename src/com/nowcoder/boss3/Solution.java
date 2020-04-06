package com.nowcoder.boss3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
* 将一个单链表倒置
* */

class ListNode {
    int val;
    ListNode next = null;
}

public class Solution {

    /**
     *
     * @param root ListNode类 链表头节点
     * @return ListNode类
     */
    public ListNode revertLinkList (ListNode root) {
        // write code here
        ListNode s = root;
        ListNode pre = null;
        while(s!=null){
            ListNode tmp = s;
            s = s.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }
}
