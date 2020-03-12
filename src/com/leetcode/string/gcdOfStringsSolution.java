package com.leetcode.string;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class gcdOfStringsSolution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) return "";
        else return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    public int gcd(int l1,int l2){
        return l2 == 0? l1:gcd(l2,l1%l2);
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        String s2 = "AB";
        gcdOfStringsSolution foo = new gcdOfStringsSolution();
        System.out.println(foo.gcdOfStrings(s1,s2));
    }
}
