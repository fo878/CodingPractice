package com.leetcode.interview;
/*
* 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。

*
* f(n) = f(n-1) + count(n)
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class countDigitOneSolution {

    public int countDigitOne(int n) {
        int a = 0;
        for (int i = 0; i < n+1; i++) {
            a = a + countOne(i);
        }
        return a;
    }

    public int countOne(int n){
        //返回数字n中1的个数
        int count = 0;
        String s = Integer.toString(n);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') count++;
        }
        return count;
    }

    private int dfs(int n) {
        if (n <= 0) {
            return 0;
        }

        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        int last = n - high * pow;

        if (high == 1) {
            // 最高位是1，如1234, 此时pow = 1000,那么结果由以下三部分构成：
            // (1) dfs(pow - 1)代表[0,999]中1的个数;
            // (2) dfs(last)代表234中1出现的个数;
            // (3) last+1代表固定高位1有多少种情况。
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
            // 最高位不为1，如2234，那么结果也分成以下三部分构成：
            // (1) pow代表固定高位1，有多少种情况;
            // (2) high * dfs(pow - 1)代表999以内和1999以内低三位1出现的个数;
            // (3) dfs(last)同上。
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }

    // 递归求解
    public int countDigitOne1(int n) {
        return dfs(n);
    }

    public static void main(String[] args) {
        int n = 12;
        countDigitOneSolution foo = new countDigitOneSolution();
        System.out.println(foo.countOne(n));
        System.out.println(foo.countDigitOne(n));
    }
}
