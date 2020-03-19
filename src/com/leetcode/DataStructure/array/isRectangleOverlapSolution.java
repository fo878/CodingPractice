package com.leetcode.DataStructure.array;

public class isRectangleOverlapSolution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x_min = rec1[0];
        int y_min = rec1[1];
        int x_max = rec1[2];
        int y_max = rec1[3];
        int[][] a = new int[][]{
                {rec2[0],rec2[1]},
                {rec2[0],rec2[3]},
                {rec2[2],rec2[1]},
                {rec2[2],rec2[3]},
        };
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            flag = flag || (a[i][0]>x_min && a[i][0]<x_max && a[i][1]>y_min && a[i][1]<y_max);
        }
        return flag;
    }

    public static void main(String[] args) {
//        int[] rec1 = {0,0,2,2};
//        int[] rec2 = {1,1,3,3};
        int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        isRectangleOverlapSolution foo = new isRectangleOverlapSolution();
        System.out.println(foo.isRectangleOverlap(rec1,rec2));
    }
}
