package com.leetcode.DataStructure.UnionFind;

import java.util.*;

/*
1202. 交换字符串中的元素
给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，
其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
* */
class smallestStringWithSwapsSolution {
    // 假如pairs = [[0,1],[1,2],[2,3]]，0、1、2是连通的，也就是说0,1,2位置可以任意交换，
    // 连通的位按字典序排序，因此考虑使用并查集
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        // 第 1 步：将任意交换的结点对输入并查集
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            uf.union(a,b);
        }
        // 第 2 步：构建映射关系
        char[] charArray = s.toCharArray();
        //map<连通分量的代表元，同一个连通分量的字符集合（优先队列）>
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (hashMap.containsKey(root)) {
                hashMap.get(root).offer(charArray[i]);
            } else {
//                hashMap.computeIfAbsent(root,key -> new PriorityQueue<>()).offer(charArray[i]);
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArray[i]);
                hashMap.put(root, minHeap);
            }
        }
        // 第 3 步：重组字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            sb.append(hashMap.get(root).poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        pairs.add(list1);
        pairs.add(list2);
        pairs.add(list3);

        smallestStringWithSwapsSolution foo = new smallestStringWithSwapsSolution();
        String res = foo.smallestStringWithSwaps(s, pairs);
        System.out.println(res);
    }
}