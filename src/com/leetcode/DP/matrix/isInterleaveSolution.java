package com.leetcode.DP.matrix;
/*
97. 交错字符串
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
* */
public class isInterleaveSolution {
    /*
    * 我们定义 f(i, j)表示 s_1 的前 i 个元素和 s_2 的前 j 个元素是否能交错组成 s_3 的前 i+j 个元素。
    如果 s_1 的第 i 个元素和 s_3 的第 i+j 个元素相等，那么 s_1 的前 i 个元素和 s_2 的前 j 个元素
    是否能交错组成 s_3 的前 i+j 个元素取决于 s_1 的前 i−1 个元素和 s_2 的前 j 个元素是否能交错组成 s_3 的前 i+j−1 个元素

    f(i,j)=[f(i-1,j) and s1(i-1)=s3(p)]or[f(i,j-1) and s2(j-1)=s3(p)]
    p=i+j-1
    f(0,0)=True
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if (n+m!=t){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        int p;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                p = i+j-1;
                if (i>0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(p)));
                }
                if (j>0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(p)));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        /*
        * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        输出: true
        * */
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        isInterleaveSolution foo = new isInterleaveSolution();
        System.out.println(foo.isInterleave(s1,s2,s3));
    }
}
