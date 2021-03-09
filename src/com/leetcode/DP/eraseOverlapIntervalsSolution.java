package com.leetcode.DP;

import java.util.Arrays;
import java.util.Comparator;

/*
*435. 无重叠区间
*给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:
可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
* */
class eraseOverlapIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        //对intervals按起点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(dp[i],max);
        }

        return n-max;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        eraseOverlapIntervalsSolution foo = new eraseOverlapIntervalsSolution();
        System.out.println(foo.eraseOverlapIntervals(intervals));
    }
}