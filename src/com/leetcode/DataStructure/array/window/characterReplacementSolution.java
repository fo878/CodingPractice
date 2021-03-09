package com.leetcode.DataStructure.array.window;
/*
* 424. 替换后的最长重复字符
* 给你一个仅由大写英文字母组成的字符串，
* 你可以将任意位置上的字符替换成另外的字符，
* 总共可最多替换 k 次。
* 在执行上述操作后，
* 找到包含重复字母的最长子串的长度。
* */
class characterReplacementSolution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;   //定义滑动窗口的指针
        int n = s.length();
        int t = k;  //用来记录可以替换的次数
        int ans = 0;
        while(j<n && i<n) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                j += 1;
                ans = Math.max(ans,j-i);
            } else if (t > 0) {
                //有机会替换
                t -= 1;
                j += 1;
                ans = Math.max(ans,j-i);
            } else {
                //没有机会替换了
                t = k;
                ans = Math.max(ans,j-i);
                //把i滑动到第一个出现字符不一样的地方
                while(i<j) {
                    char c3 = s.charAt(i);
                    if (c3 != c1) {
                        break;
                    }else {
                        i += 1;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        characterReplacementSolution foo = new characterReplacementSolution();
        System.out.println(foo.characterReplacement(s,k));
    }

}