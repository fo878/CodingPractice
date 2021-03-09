package com.leetcode.DataStructure.array.window;

/*
* 1208. 尽可能使字符串相等
给你两个长度相同的字符串，s 和 t。
将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * */
class equalSubstringSolution {
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] SChars = s.toCharArray();
        char[] TChars = t.toCharArray();
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int costI = Math.abs(SChars[i] - TChars[i]);
            costs[i] = costI;
        }
        int i=0,j=0;
        int sum = 0;
        int result = 0;
        while (j<costs.length) {
            sum += costs[i];
            while (sum > maxCost) {
                sum -= costs[i];
                i += 1;
            }
            result = Math.max(result,j-i+1);
            j += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = equalSubstring("krrgw", "zjxss", 19);
        System.out.println(i);
    }
}