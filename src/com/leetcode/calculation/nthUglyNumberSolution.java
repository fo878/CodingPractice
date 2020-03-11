package com.leetcode.calculation;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
*
*   // 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
    // 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
    // 3.采取用三个指针的方法，p2,p3,p5
    // 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
    // 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
    // 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
    // 7.p3,p5同理
    // 8.返回第n个丑数

作者：panc-2
链接：https://leetcode-cn.com/problems/chou-shu-lcof/solution/dong-tai-gui-hua-java100miao-sha-nei-you-xiang-xi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
public class nthUglyNumberSolution {
    public int nthUglyNumber(int n) {
        int p2=0,p3=0,p5=0;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if (dp[i] == dp[p2]*2) p2++;
            if (dp[i] == dp[p3]*3) p3++;
            if (dp[i] == dp[p5]*5) p5++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 11;  //1,2,3,4,5,6,8,9,10,12,14,15
        nthUglyNumberSolution foo = new nthUglyNumberSolution();
        System.out.println(foo.nthUglyNumber(n));
    }
}
