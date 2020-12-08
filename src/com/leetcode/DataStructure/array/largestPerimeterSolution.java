package com.leetcode.DataStructure.array;

import java.util.Arrays;

/**
 * 976
 *  给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
class largestPerimeterSolution {
    public int largestPerimeter(int[] A) {
        if (A.length<3) {
            return 0;
        }
        Arrays.sort(A);
        int ans = 0;
        for (int i = 2; i < A.length; i++) {
            int first = i-2;
            int second = i-1;
            if (A[first] + A[second] > A[i]) {
                ans = Math.max(ans,A[first] + A[second] + A[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A1 = new int[]{2,1,2};//5
        int[] A2 = new int[]{1,2,1};//0
        int[] A3 = new int[]{3,2,3,4};//10
        int[] A4 = new int[]{3,6,2,3};//8
        largestPerimeterSolution foo = new largestPerimeterSolution();
        System.out.println(foo.largestPerimeter(A1));
        System.out.println(foo.largestPerimeter(A2));
        System.out.println(foo.largestPerimeter(A3));
        System.out.println(foo.largestPerimeter(A4));
    }
}