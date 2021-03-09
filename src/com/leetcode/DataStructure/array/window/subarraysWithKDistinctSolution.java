package com.leetcode.DataStructure.array.window;
/*
* 992. K 个不同整数的子数组
* 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，
* 则称 A 的这个连续、不一定独立的子数组为好子数组。
*（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
* 返回 A 中好子数组的数目。
* */
class subarraysWithKDistinctSolution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A,K) - atMostKDistinct(A,K-1);
    }

    /**
     * @param A 正整数数组
     * @param K K个不同整数的子数组
     * @return 最多包含K个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len+1];
        int left = 0;
        int right = 0;
        // [left,right)里不同整数的个数
        int count = 0;
        int res = 0;
        //[left,right)里包含不同整数的个数等于K
        while (right<len) {
            if (freq[A[right]] == 0) {
                count += 1;
            }
            freq[A[right]] += 1;
            right += 1;

            while (count > K) {
                freq [A[left]] -= 1;
                if (freq[A[left]] == 0) {
                    count -= 1;
                }
                left += 1;
            }
            res += right - left;
        }
        return res;
    }
}