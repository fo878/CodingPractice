package com.leetcode.DataStructure.array;

import java.lang.reflect.Constructor;
import java.util.*;

/*
* 合并区间
* 给出一个区间的集合，请合并所有重叠的区间。
*
* 示例1：
* 输入: [[1,3],[2,6],[8,10],[15,18]]
* 输出: [[1,6],[8,10],[15,18]]
* 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

* 输入: [[1,4],[4,5]]
* 输出: [[1,5]]
* 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
//class Point{
//    int a;
//    int b;
//    int[] num;
//
//    public Point(int[] num) {
//        this.a = num[0];
//        this.b = num[1];
//        this.num = num;
//    }
//}

public class mergeSolution {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n<2) return intervals;
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        LinkedList<int[]> res = new LinkedList<int[]>();
        int[] first = intervals[0];
        for (int i = 1; i < n; i++) {
            if (first[1]<intervals[i][0]){
                res.add(first);
                first = intervals[i];
            }else {
                first[1] = Math.max(intervals[i][1],first[1]);
            }
            if (i==n-1){
                res.add(first);
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[][] in1 = new int[][]{
                {1,3},{2,6},{8,10},{11,18}
        };
        int[][] in2 = new int[][]{
                {1,4},{2,3}
        };
        int[][] out1 = merge(in1);
        for (int i = 0; i < out1.length; i++) {
            System.out.println(Arrays.toString(out1[i]));
        }

        int[][] out2 = merge(in2);
        for (int i = 0; i < out2.length; i++) {
            System.out.println(Arrays.toString(out2[i]));
        }
    }
}
