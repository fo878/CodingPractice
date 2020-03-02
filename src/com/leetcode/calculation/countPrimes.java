package com.leetcode.calculation;

import java.util.Arrays;

/*统计所有小于非负整数 n 的质数的数量。
*
* 埃拉托色尼筛选法：
*
*
* */
public class countPrimes {
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
}
