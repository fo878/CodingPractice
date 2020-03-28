package com.leetcode.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*低位优先的字符串排序*/
public class LSD {
    public static void sort(String[] a,int W){
        //通过前w个字符将a[] 排序
        int N = a.length;
        int R = 256;//ASCII共256个字符
        String[] aux = new String[N];
        for (int d = W-1; d >= 0 ; d--) {
            // 根据第d个字符用键索引计数法排序

            // 计算字符出现的频率
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;//第i个字符串中第d个字符出现的频率
            }
            // 将频率转换为起始索引
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            // 将元素分类，所有元素移动到一个辅助数组中进行排序
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // 回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        String[] a = StdIn.readAllStrings();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] a = line.trim().split(" ");
        int n = a.length;

        // check that strings have fixed length
        int w = a[0].length();
        for (int i = 0; i < n; i++)
            assert a[i].length() == w : "Strings must have fixed length";

        // sort the strings
        sort(a, w);

        // print results
        for (int i = 0; i < n; i++)
            System.out.println(a[i]);
    }
}
