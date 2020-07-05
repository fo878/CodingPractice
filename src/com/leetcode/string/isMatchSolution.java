package com.leetcode.string;

/*
* 44. 通配符匹配
* 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
* 两个字符串完全匹配才算匹配成功。
* 说明:
    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/wildcard-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class isMatchSolution {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1; j <= n ; ++j) {
            if (p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }else {
                break;
            }
        }
        for (int i = 1; i <= m ; ++i) {
            for (int j = 1; j <= n ; ++j) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aabbbbbccc";
        String p = "aa*c";
        System.out.println(isMatch(s,p));
    }

}
