package com.leetcode.DataStructure.list;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class getIntersectionNodeSolution {

    /*
    * 我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
    * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，
    * 重新定位到链表 headA 的头结点。
      这样，当它们相遇时，所指向的结点就是第一个公共结点。
    *
    * */
    public ListNode getIntersectionNode(int intersectVal,ListNode headA,ListNode headB,int skipA,int skipB){
        return getIntersectionNode(headA,headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null ||headB == null){
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2){
            if (cur1 == null){
                cur1 = headB;
            }else {
                cur1 = cur1.next;
            }
            if (cur2 == null){
                cur2 = headA;
            }else {
                cur2 = cur2.next;
            }
        }
        return cur1;
    }
}

public class getIntersectionNodeMainClass {
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
            int intersectVal = Integer.parseInt(line);
            line = in.readLine();
            ListNode listA = stringToListNode(line);
            line = in.readLine();
            ListNode listB = stringToListNode(line);
            line = in.readLine();
            int skipA = Integer.parseInt(line);
            line = in.readLine();
            int skipB = Integer.parseInt(line);

            ListNode ret = new getIntersectionNodeSolution().getIntersectionNode(intersectVal, listA, listB, skipA, skipB);
            //ListNode ret = new getIntersectionNodeSolution().getIntersectionNode(listA, listB);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}