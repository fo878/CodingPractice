package com.nowcoder.alibaba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* 题目描述：
* 小强开始了他的功夫特训，特训时间为n秒，有m个木头人，每个木头人的血量为a，小强的攻击范围为b
* 小强每次攻击最多能对b个存活的木头人造成1点伤害，每次攻击需要1秒。当经过一次攻击后木头人的血量为0，木头人死亡
* 问特训结束时，小强能消灭多少个木头人。
*
* input:
* 1
* 5 5 2 2
*
* output:
* 5
* */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] lines = new String[N];
        int[] nums = new int[4];
        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine();
            String[] strings = lines[i].trim().split(" ");
            nums[0] = Integer.parseInt(strings[0]);
            nums[1] = Integer.parseInt(strings[1]);
            nums[2] = Integer.parseInt(strings[2]);
            nums[3] = Integer.parseInt(strings[3]);
            System.out.println(calculator(nums[0],nums[1],nums[2],nums[3]));
        }
    }

    private static int calculator(int n,int m,int a,int b){

        int res = 0;
        int[] bots = new int[m];
        for (int i = 0; i < m; i++) {
            bots[i] = a;
        }
        //b是攻击范围，n是时间，res是最多死掉木头人数量
        while (n>0){//倒计时开始
            //1s内能让b个木头人各掉1滴血

            n--;
        }
        return res;
    }
}
