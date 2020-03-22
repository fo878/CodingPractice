package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
* 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
* 返回使 A 中的每个值都是唯一的最少操作次数。
* */
public class minIncrementForUnique {
    public int minIncrementForUnique1(int[] A) {//动态规划，超时
        int count = 0;
        int len = A.length;
        if (len==0){
            return 0;
        }
        int dp[] = new int[len];
        dp[0] = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(A[0]);
        for (int i = 1; i < dp.length; i++) {
            if (set.add(A[i])){
                dp[i] = dp[i-1];
            }else {
                while (set.contains(A[i])){
                    A[i] += 1;
                    count++;
                }
                set.add(A[i]);
                dp[i] = dp[i-1] + count;
                count = 0;
            }
        }
        return dp[len-1];
    }


    public int minIncrementForUnique(int[] A) {//排序，通过
        Arrays.sort(A);
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i]<=A[i-1]){
                res += A[i-1]-A[i]+1;
                A[i] = A[i-1]+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,2,1,7};
        minIncrementForUnique foo = new minIncrementForUnique();
        System.out.println(foo.minIncrementForUnique(A));
    }
}
