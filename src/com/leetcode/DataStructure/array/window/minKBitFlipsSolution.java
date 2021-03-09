package com.leetcode.DataStructure.array.window;
/*
* 995. K 连续位的最小翻转次数
*
在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，
同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。
如果不可能，返回 -1。*/


class minKBitFlipsSolution {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n+1];
        int ans = 0;
        int revCnt = 0;
        for (int i = 0; i < n; i++) {
            revCnt +=  diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ans += 1;
                revCnt += 1;
                diff[i + K] -= 1;
            }
        }
        return ans;
    }
}

/*
 * 查分数组
 * 我们可以维护一个差分数组 diff，其中 iff[i] 表示两个相邻元素 A[i-1]和A[i] 的翻转次数的差
 * */
