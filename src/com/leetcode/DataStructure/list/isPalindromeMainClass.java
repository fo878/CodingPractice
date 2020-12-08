package com.leetcode.DataStructure.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class isPalindromeSolution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        List<Integer> list= new LinkedList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        for (int i = 0; i < n/2; i++) {
            if(!list.get(i).equals(list.get(n-i-1))){
                return false;
            }
        }
        return true;
    }
}

public class isPalindromeMainClass {
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
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            
            boolean ret = new isPalindromeSolution().isPalindrome(head);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}