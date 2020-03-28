package com.nowcoder.tiger2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
*在某个仓库中，堆积了很多的货物。每个货物是一个正方体的，边长为1。所有货物恰好堆积成一个长方体，边长为R*C*L。
目前，在某次确认货物的时候，管理员意识到这一堆货物被小偷偷走了一些。
* 这个小偷将原来的R*C*L的货物组成的长方体偷成了恰好(R-2)*(C-1)*(L-2)的长方体。
但是管理员记不得的R,C,L具体数值了，他只能计算现在的货物总数。
* 他希望算出来最坏情况下被偷了多少的货物，输出这个最坏的值。
*
* 输入为一个数n,表示题面中的(R-2)*(C-1)*(L-2)
* 输出为一个数，表示最坏情况下被偷了多少的货物
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
