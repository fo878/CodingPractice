package com.nowcoder.tiger1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*


* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine().trim();
        int n = Integer.parseInt(line1);//圆环的个数
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        int res =0 ;
        System.out.println(res);
    }
}
