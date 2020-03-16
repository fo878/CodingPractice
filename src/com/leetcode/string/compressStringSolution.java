package com.leetcode.string;
class compressStringSolution {
    public String compressString(String S) {
        String S1 = S + "#";
        char[] chars = S1.toCharArray();
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<chars.length;i++) {
            int j = i - 1;
            if (chars[i] != chars[j]) {
                sb.append(chars[j]).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        if(sb.length() < S.length()){
            return sb.toString();
        }else{
            return S;
        }
    }

    public static void main(String[] args) {
        String S1 = "aabcccccaa";
        String S2 = "abc";
        compressStringSolution foo = new compressStringSolution();
        System.out.println(foo.compressString(S1));//a2b1c5a2
        System.out.println(foo.compressString(S2));
    }
}