package com.leetcode.DataStructure.Tree;

import java.util.HashMap;
import java.util.Map;

/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*
*
二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。

前序遍历的第一个节点是根节点，只要找到根节点在中序遍历中的位置，在根节点之前被访问的节点都位于左子树，
在根节点之后被访问的节点都位于右子树，由此可知左子树和右子树分别有多少个节点。

由于树中的节点数量与遍历方式无关，通过中序遍历得知左子树和右子树的节点数量之后，
可以根据节点数量得到前序遍历中的左子树和右子树的分界，因此可以进一步得到左子树和右子树各自的前序遍历和中序遍历，
可以通过递归的方式，重建左子树和右子树，然后重建整个二叉树。

使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。
调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数。

递归方法的基准情形有两个：判断前序遍历的下标范围的开始和结束，
* 若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
* 若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
* 若开始小于结束，则当前的二叉树中有多个节点。
*   在中序遍历中得到根节点的位置，从而得到左子树和右子树各自的下标范围和节点数量，
*   知道节点数量后，在前序遍历中即可得到左子树和右子树各自的下标范围，然后递归重建左子树和右子树，
*   并将左右子树的根节点分别作为当前根节点的左右子节点。

* */
class reConstructBinaryTree {
    //递归的方法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length==0) return null;
        HashMap<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
        //把中序遍历的元素和对应元素的位置保存到map中
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        //递归使用buildTree，构建二叉树
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap){
        //判断前序遍历的下标范围的开始和结束
        //若开始大于结束，则当前的二叉树中没有节点，返回空值 null
        if (preorderStart>preorderEnd) return null;
        //若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
        int root_val = preorder[preorderStart];
        TreeNode root = new TreeNode(root_val);
        if (preorderStart==preorderEnd) return root;
        else {//若开始小于结束，则当前的二叉树中有多个节点。
            //在中序遍历中得到根节点的位置(已保存到indexMap中)，从而得到左子树和右子树各自的下标范围和节点数量
            int rootIndex = indexMap.get(root_val);
            int leftNodes = rootIndex-inorderStart;//左节点的数量
            int rightNodes = inorderEnd-rootIndex;//右节点的数量
            TreeNode leftSubTree = buildTree(preorder,preorderStart+1,preorderStart+leftNodes,inorder,inorderStart,rootIndex-1,indexMap);//递归构建左子树
            TreeNode rightSubTree = buildTree(preorder,preorderEnd-rightNodes+1,preorderEnd,inorder,rootIndex+1,inorderEnd,indexMap);//递归构建右子树
            //拼接左子树和右子树于根节点
            root.left = leftSubTree;
            root.right = rightSubTree;
        }
        return root;
    }
}
