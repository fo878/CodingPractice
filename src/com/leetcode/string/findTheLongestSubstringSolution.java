package com.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/*
* 1371. 每个元音包含偶数次的最长子字符串
* 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，
* 即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
* */
public class findTheLongestSubstringSolution {

    /*
    * 我们对每个元音字母维护一个前缀和，定义pre[i][k] 表示在字符串前i个字符中，第k个元音字母一共出现的次数。
    * 假设我们需要求出 [l,r]这个区间的子串是否满足条件，那么我们可以用 pre[r][k]−pre[l−1][k]，
    * 在 O(1)的时间得到第k个元音字母出现的次数。对于每一个元音字母，我们都判断一下其是否出现偶数次即可。
    *
    * 我们考虑枚举字符串的每个位置 i ，计算以它结尾的满足条件的最长字符串长度。其实我们要做的就是快速找到最小的 j
    * j∈[0,i)，满足 pre[i][k]-pre[j][k]（即每一个元音字母出现的次数）均为偶数，
    * 那么以 i 结尾的最长字符串 s[j+1,i] 长度就是 i-j。
    *
    * 我们就可以利用哈希表存储每一种奇偶性（即考虑所有的元音字母）对应最早出现的位置，边遍历边更新答案。
    * 进一步优化我们的编码方式
    * 额外定义一个状态：
    * 压缩到一个二进制数中,[(00000),(11111)]
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/mei-ge-yuan-yin-bao-han-ou-shu-ci-de-zui-chang-z-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */

    public int findTheLongestSubstring(String s){
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos,-1);
        int ans = 0;
        int status = 0;
        pos[0] = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch=='a'){
                status ^= (1);
            }else if (ch=='e'){
                status ^= (1<<1);
            }else if (ch=='i'){
                status ^= (1<<2);
            }else if (ch=='o'){
                status ^= (1<<3);
            }else if (ch=='u'){
                status ^= (1<<4);
            }
            if (pos[status]>=0){
                ans = Math.max(ans,i+1-pos[status]);
            }else {
                pos[status] = i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s =  "eleetminicoworoep";
        findTheLongestSubstringSolution foo = new findTheLongestSubstringSolution();
        System.out.println(foo.findTheLongestSubstring(s));
    }
}
