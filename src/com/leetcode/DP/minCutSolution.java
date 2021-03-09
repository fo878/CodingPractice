package com.leetcode.DP;

import java.util.Arrays;

/*
132. 分割回文串 II
 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 返回符合要求的 最少分割次数 。
 f[i]=  min{f[j]} + 1          其中 s[j+1..i] 是一个回文串
          0≤j<i

 注意到上面的状态转移方程中，我们还少考虑了一种情况，即 s[0..i]s[0..i] 本身就是一个回文串。此时其不需要进行任何分割

* */
class minCutSolution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],true);
        }

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i+1; j < n; j++) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i+1][j-1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j+1][i]) {
                        f[i] = Math.min(f[i],f[j]+1);
                    }
                }
            }
        }
        return f[n-1];
    }
}