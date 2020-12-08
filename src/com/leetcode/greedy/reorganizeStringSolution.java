package com.leetcode.greedy;
// 767. 重构字符串
// 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
// 若可行，输出任意可行的结果。若不可行，返回空字符串。
//
// 示例 1:
//
//
//输入: S = "aab"
//输出: "aba"
//
// 示例 2:
//
//输入: S = "aaab"
//输出: ""
//
// 注意:
// S 只包含小写字母并且长度在[1, 500]区间内。
class reorganizeStringSolution {
    public String reorganizeString(String S) {
        //统计每个字符出现的次数
        if (S.length() < 1) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            counts[S.charAt(i) - 'a'] += 1;
            maxCount = Math.max(maxCount,counts[S.charAt(i)-'a']);
        }
        if (maxCount > (n+1)/2) {
            return "";
        }
        // 基于贪心算法，讨论将最多字符放置到什么位置
        // 假设n为奇数，n=5，maxCount=3的话，一定要放在从零开始偶数位上（0,2,4）
        // 假设n为偶数，n=6, maxCount=3的话，放在奇数位和偶数位都行，
        // 因为可以输出任意结果，所以和n为奇数时保持一致，统一将最多字符放在偶数位置上
        char[] reorganizeString = new char[n];
        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = n/2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i]>0 && counts[i]<=halfLength && oddIndex<n) {
                reorganizeString[oddIndex] = c;
                oddIndex += 2;
                counts[i] -= 1;
            }
            while (counts[i] > 0) {
                reorganizeString[evenIndex] = c;
                evenIndex += 2;
                counts[i] -= 1;
            }
        }
        return new String(reorganizeString);
    }

    public static void main(String[] args) {
        reorganizeStringSolution foo = new reorganizeStringSolution();
        System.out.println(foo.reorganizeString("aa"));
        System.out.println(foo.reorganizeString("aab"));
        System.out.println(foo.reorganizeString("aabb"));
        System.out.println(foo.reorganizeString("aaab"));
        System.out.println(foo.reorganizeString("a"));
    }
}