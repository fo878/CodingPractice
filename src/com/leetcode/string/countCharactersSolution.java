package com.leetcode.string;
/*
Title：拼写单词  simple
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.
Example 1:
    Input: words = ["cat","bt","hat","tree"], chars = "atach"
    Output: 6
    Explanation:The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

*/
import java.util.LinkedList;
public class countCharactersSolution {

    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if(isGoodString(words[i],chars)){
                sum += words[i].length();
            }
        }
        return sum;
    }

    public boolean isGoodString(String word,String chars){
        LinkedList<Character> charList = new LinkedList<Character>();
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            charList.add(c);
        }
        for (int i = 0; i < word.length(); i++) {
            if (!charList.contains(word.charAt(i))){
                return false;
            }else {
                charList.removeFirstOccurrence((Object)word.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] words = {"cat","bt","hat","tree"};
//        String chars = "atach";
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        countCharactersSolution foo = new countCharactersSolution();
        System.out.println(foo.countCharacters(words,chars));
    }
}
