package com.leetcode.string;

import java.util.HashSet;

public class isUniqueSolution {
    public boolean isUnique(String astr) {
        HashSet<Character> set = new HashSet();
        for(int i=0;i<astr.length();i++){
            set.add(astr.charAt(i));
        }
        return astr.length() == set.size();
    }
}
