package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 77. 组合
*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
* */
public class combineSolution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return res;
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> track) {
        // 到达树的底部
        if (k == track.size()) {
            res.add(new ArrayList<Integer>(track));
            return;
        }
        // 注意 i 从 start 开始递增
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(i);
            backtrack(n, k, i + 1, track);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        combineSolution foo = new combineSolution();
        List<List<Integer>> combine = foo.combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(integers.toString());
        }
    }
}
