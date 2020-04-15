package com.leetcode.DataStructure.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class addTwoNumbersSolution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        StringBuffer s1 = new StringBuffer();
        while (l1!=null){
            s1.append(l1.val);
            l1 = l1.next;
        }
        StringBuffer s2 = new StringBuffer();
        while (l2!=null){
            s2.append(l2.val);
            l2 = l2.next;
        }
        int res = Integer.parseInt(s2.toString()) + Integer.parseInt(s1.toString());
        //input: [3,9,9,9,9,9,9,9,9,9]
        //       [7]
        //Exception in thread "main" java.lang.NumberFormatException: For input string: "3999999999"
        char[] chars = Integer.toString(res).toCharArray();
        ListNode node = new ListNode(chars[0]-'0');
        ListNode ptr = node;
        for(char c : chars) {
            ptr.next = new ListNode(c-'0');
            ptr = ptr.next;
        }
        return node.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverseList(l1);
        ListNode revL2 = reverseList(l2);
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        int add = 0;
        while (revL1!=null || revL2!=null){
            if (revL1 == null){
                ptr.next =  new ListNode((revL2.val + add) % 10);
                add = (revL2.val + add) / 10;
                ptr = ptr.next;
                revL2 = revL2.next;
            }else if (revL2 == null){
                ptr.next =  new ListNode((revL1.val + add) % 10);
                add = (revL1.val + add) / 10;
                ptr = ptr.next;
                revL1 = revL1.next;
            }else {
                ptr.next =  new ListNode((revL1.val + revL2.val + add) % 10);
                add = (revL1.val + revL2.val + add) / 10;
                ptr = ptr.next;
                revL1 = revL1.next;
                revL2 = revL2.next;
            }
        }
        if (add!=0){
            ptr.next = new ListNode(add);
        }
        return reverseList(ans.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

public class addTwoNumbersMainClass {

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
            ListNode ret = new addTwoNumbersSolution().addTwoNumbers(l1, l2);
            String out = listNodeToString(ret);
            System.out.print(out);
        }
    }
}