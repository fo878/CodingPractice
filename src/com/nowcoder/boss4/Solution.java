package com.nowcoder.boss4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long n = Long.parseLong(line);
        String s = Long.toBinaryString(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}
