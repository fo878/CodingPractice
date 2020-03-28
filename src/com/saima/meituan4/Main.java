package com.saima.meituan4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 小仓酷爱射击运动。今天的小仓会进行N轮射击，已知每次击中靶心的概率为p/q，每
* 当小仓击中靶心，如果是连续k次击中，那么小仓会获得a[k]的得分。
* 小仓希望知道最后她的期望得分是多少。
*
* input:
* 第一行三个数N，p，q代表射击轮数以及击中靶心概率。
第二行N个数a[i]，第i个数为a[i]。
1<=N<=100000
0<=a[i]<998244353
1<=p,q<998244353
*
* output:
* 一个数表示期望得分。
不难证明答案有唯一的最简分数表示，若答案的最简表示为A/B，请输出A*B-1(mod 998244353)，
* B-1表示B在模998244353意义下的逆元，满足B-1*B≡1(mod 998244353)。
* 又已知B-1≡B998244351（mod 998244353），故仅需输出A*B998244351(mod 998244353)。
* （ “≡”为数论中表示同余的符号）
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line1[0]);//N轮
        int P = Integer.parseInt(line1[1]);//N轮
        int Q = Integer.parseInt(line1[2]);//N轮
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        double lv = (double)P/(double)Q;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }
        System.out.println(sum*lv);
    }
}
