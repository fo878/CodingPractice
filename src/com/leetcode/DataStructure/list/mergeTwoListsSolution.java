package com.leetcode.DataStructure.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
*
* 分析：
*   1.创建一个头结点用来连排序后的链表
    2.比较两链表当前值，小的就放入新链表，更新next值
    3.最后把非空链表剩余部分挂上新链表
*
* */
class mSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2!=null){
            if (l1.val>=l2.val){
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
            else {
                p.next = l1;
                p=p.next;
                l1 = l1.next;
            }
        }
        if (l1 != null){
            p.next = l1;
        }
        if (l2!= null){
            p.next = l2;
        }
        return head.next;
    }
}
public class mergeTwoListsSolution {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new mSolution().mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}