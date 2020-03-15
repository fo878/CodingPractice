package com.OJ.template;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFSTemplate {
    /*
     * 递归  DFS
     * Return true if there is a path from cur to target
     * */
    boolean DFS (Node cur, Node target, Set<Node> visited){
        if (cur==target){
            return true;
        }
        for (Node next : cur.neighbors) {
            if (!visited.contains(next)){
                visited.add(next);
                return DFS(next,target,visited);
            }
        }
        return false;
    }

    /*
     * 非递归  DFS
     * Return true if there is a path from cur to target
     * */
    boolean DFS(Node root, Node target){
        Set<Node> visited = new HashSet<>();
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while(!s.isEmpty()){
            Node cur = s.peek();
            if (cur==target) {
                return true;
            }
            for (Node next : cur.neighbors) {
                if (!visited.contains(next)){
                    s.add(next);
                    visited.add(next);
                }
            }
            s.remove(cur);
        }
        return false;
    }
}
