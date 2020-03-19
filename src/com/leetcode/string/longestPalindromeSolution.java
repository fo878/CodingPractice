package com.leetcode.string;
/*
* Longest Palindrome
* Given a string which consists of lowercase or uppercase letters,
* find the length of the longest palindromes that can be built with those letters.
* This is case sensitive, for example "Aa" is not considered a palindrome here.
* Note:
* Assume the length of given string will not exceed 1,010.
*
* Input:"abccccdd"
* Output:7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*
* 分析：
*   如果所有字符出现的个数都是偶数，最长回文子串长度必为字符串的长度
*   否则将统计所有出现偶数次的字符个数num，最长回文子串长度为num+1
* */
import java.util.*;
public class longestPalindromeSolution {
    public int longestPalindrome(String s){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();//key为字符，value为字符出现的次数
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i],1);
            }
        }
        int num2 = 0,num1 = 0,flag = 0;//num2统计偶数个，num1统计奇数个
        for (Character character : map.keySet()) {
            if (map.get(character)%2==0){
                num2 += map.get(character);
            }else {
                flag = 1;
                if (map.get(character)>1){
                    num1 += map.get(character)-1;
                }
            }
        }
        return num2 + num1 +flag;
    }
/*
* 官方题解
* 对于每个字符 ch，假设它出现了 v 次，我们可以使用该字符 v / 2 * 2 次，在回文串的左侧和右侧分别放置 v / 2 个字符 ch，
* 其中 / 为整数除法。例如若 "a" 出现了 5 次，那么我们可以使用 "a" 的次数为 4，回文串的左右两侧分别放置 2 个 "a"。
* 如果有任何一个字符 ch 的出现次数 v 为奇数（即 v % 2 == 1），那么可以将这个字符作为回文中心，
* 注意只能最多有一个字符作为回文中心。在代码中，我们用 ans 存储回文串的长度，由于在遍历字符时，
* ans 每次会增加 v / 2 * 2，因此 ans 一直为偶数。
* 但在发现了第一个出现次数为奇数的字符后，我们将 ans 增加 1，
* 这样 ans 变为奇数，在后面发现其它出现奇数次的字符时，我们就不改变 ans 的值了。
* */
    public int longestPalindrome1(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "abccccdd";
        longestPalindromeSolution foo = new longestPalindromeSolution();
        System.out.println(foo.longestPalindrome(a));
    }
}
