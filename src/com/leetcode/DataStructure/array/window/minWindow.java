package com.leetcode.DataStructure.array.window;
/*
*76. 最小覆盖子串
*  给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
*
* 输入: S = "ADOBECODEBANC", T = "ABC"  注意T可能包含重复字符
* 输出: "BANC"
*
* 说明：
如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
* */
public class minWindow {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen<tLen){
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        //ascii字符到z是122,128够用了,HashMap也可以
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        //滑动窗口内部包含多少T中的字符
        int distance = 0;
        int minLen = sLen+1;
        int begin = 0;

        int left = 0;
        int right = 0;
        //[left,right)
        while(right<sLen){
            if (tFreq[charArrayS[right]]==0){
                right++;
                continue;
            }

            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]] ){
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while(distance == tLen){

                if (right-left < minLen){
                    minLen = right - left;
                    begin = left;
                }
                if (tFreq[charArrayS[left]]==0){
                    left++;
                    continue;
                }

                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }
        }
        if (minLen == sLen + 1){
            return "";
        }else {
            return s.substring(begin,begin + minLen);
        }
    }
}
