package com.leetcode.DataStructure.Tree.BST;
/*
* 二叉查找树的实现
* */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node {
        private Key key;//键
        private Value val;//值
        private Node left, right;//左子节点，右子节点
        private int N;//该节点为根的子树中的节点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if (x == null)return 0;
        else return x.N;
    }

    public Value get(Key key){
        //二叉树的查找方法
        return get(root,key);
    }

    public Value get(Node x,Key key){
        //二叉树的查找方法  (递归方法实现)
        /*
        * 在以x为根节点的子树中查找并返回key所对应的值
        * 如果找不到就返回null
        * */
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) return get(x.left,key);
        if(cmp>0) return get(x.right,key);
        else return x.val;
    }

    public void put(Key key,Value val){
        //二叉树的插入方法
        root = put(root,key,val);
    }

    public Node put(Node x,Key key,Value val){
        //二叉树的添加方法（插入）
        //如果key存在于以x为根节点的子树中则更新它的值
        //否则将key和val为键值对的新节点插入到该子树中
        if (x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = put(x.left,key,val);
        else if (cmp>0) x.right = put(x.right,key,val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        //求最小键
        if (x.left == null) return x;
        return x.left;
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        //求最大键
        if (x.right == null) return x;
        return x.right;
    }

    public Key floor (Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        // 找小于等于key的最大键
        if (x == null) return null;//空节点返回null
        int cmp = key.compareTo(x.key);//把要找的key和根节点x的key作比较
        if (cmp == 0) return x;//如果要找的key恰好等于x的key，那x就是小于等于key的最大键，满足等于
        //如果我们要找的key比x的key小，则要找的key一定出现在x的左子树中，应递归调用floor方法
        if (cmp < 0) return floor(x.left,key);
        //如果我们要找的key大于等于x.key，则要找的key可能出现在x的右子树中，递归查找右子树有没有小于等于key的最大键
        //如果出现了，t不为null，返回t，如果没出现说明x就是要找的键
        Node t = floor(x.right,key);
        if (t != null)return t;
        else return x;
    }

    public Key ceiling (Key key){
        Node x = ceiling(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x,Key key){
        //大于等于key的最小键
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right,key);
        Node t = ceiling(x.left,key);
        if (t != null)return t;
        else return x;
    }

    public Key select(int k){
        return select(root,k).key;
    }

    private Node select(Node x,int k){
        //选择排名第k的节点
        if (x == null) return null;
        int t = size(x.left);
        if (t>k) return select(x.left,k);
        else if (t<k) return select(x.right,k);
        else return x;
    }

    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        //返回以x为根节点的子树中小于x.key键的数量
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp<0) return rank(key,x.left);
        else if (cmp>0) return size(x.left)+rank(key,x.right)+1;
        else return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){

        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = delete(x.left,key);
        else if (cmp>0) x.right = delete(x.right,key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
