package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//public boolean isSubStructure(TreeNode A, TreeNode B) {
//        return A != null && B != null ? recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B) : false;
//        }
//        boolean recur(TreeNode A, TreeNode B) {
//        if(B == null) return true;
//        if(A == null || A.val != B.val) return false;
//        return recur(A.left, B.left) && recur(A.right, B.right);
//        }
class isSubStructurSolution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B==null){
            return false;
        }else if(recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B)){
            return true;
        }else return false;
    }

    private boolean recur(TreeNode A, TreeNode B){
        if (B==null){
            return true;
        }if (A==null || A.val != B.val){
            return false;
        }else
            return recur(A.left,B.left) && recur(A.right,B.right);
    }
}

public class isSubStructureSolution {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode A = stringToTreeNode(line);
            line = in.readLine();
            TreeNode B = stringToTreeNode(line);

            boolean ret = new isSubStructurSolution().isSubStructure(A, B);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}