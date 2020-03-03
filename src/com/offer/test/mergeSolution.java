package com.offer.test;

import java.util.Arrays;

/*
* 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sorted-merge-lcci
* */
public class mergeSolution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(k>=0){
            if (i <0 ){
                A[k--] = B[j--];
            }else if (j<0) {
                A[k--] = A[i--];
            }else {
                A[k--] = A[i] < B[j]? B[j--]:A[i--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] B = new int[]{2,5,6};
        int n = 3;
        mergeSolution foo = new mergeSolution();
        foo.merge(A,m,B,n);
        System.out.println(Arrays.toString(A));
    }
}
