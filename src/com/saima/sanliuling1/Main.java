package com.saima.sanliuling1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
* 西西是某公司的一名员工，该公司目前正在做的项目还有N天截止。
* 为鼓励员工加班，在这N天内该公司每天都会为当天加班的员工发放奖金。
* 具体来说，对于当天加班的某位员工，若该员工已经连续加班了i天（1≤i≤N），
* 则其当天能获得的奖金为i（例如 ，第一天加班，则此时记为连续加班1天，获得的奖金为1）。
* 西西制定了这N天内的加班计划，他每天要么加班，要么不加班，
* 要么不确定加不加班（有50%的概率加班，剩下50%的概率不加班），
* 那么西西在这N天内能获得的总奖金的期望是多少？
*
* input：
第一行包含一个整数N，1≤N≤105。
第二行包含N个空格隔开的整数t1到tN，0≤ti≤2。若ti=0，
* 则表示西西在第i天不加班；若ti=1，则表示西西在第i天会加班；
* 若ti=2，则表示西西在第i天有50%的概率加班，剩下50%的概率不加班。
*
output：
* 输出总奖金的期望，结果只保留整数部分。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1);
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        int ans = 0;
        int cur = 1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1){
                ans += cur*num[i];
                cur++;
            }if (num[i] == 0){
                cur = 1;
            }
        }
        System.out.println(ans);
    }
}
