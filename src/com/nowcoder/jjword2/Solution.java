package com.nowcoder.jjword2;
import java.util.*;


public class Solution {
    /**
     * 求第N个数
     * @param n int整型 第n个数
     * @return int整型
     */

    public int Foo(int n) {
        // write code here
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;//十亿零七
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            Solution foo = new Solution();
            System.out.println(foo.Foo(a));
        }
    }
}