package com.leetcode.DataStructure.array;
/*
* 896. 单调数列
* 如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。
* */
class isMonotonicSolution {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        int[] Arr = new int[n];
        Arr[0] = 0;
        for (int i = 1; i < n; i++) {
            Arr[i] = A[i] - A[i-1];
        }

        return isInc(Arr) || isDec(Arr);
    }

    private boolean isDec(int[] arr) {
        for (int a : arr) {
            if (a > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isInc(int[] arr) {
        for (int a : arr) {
            if (a < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,2};
        isMonotonicSolution foo = new isMonotonicSolution();
        System.out.println(foo.isMonotonic(A));
    }
}