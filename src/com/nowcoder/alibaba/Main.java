package com.nowcoder.alibaba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
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

        LinkedList<Integer> bots = new LinkedList<Integer>();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            bots.add(a);
            sum+=a;
        }
        //b是攻击范围，n是时间，res是最多死掉木头人数量
        if (a > n){
            return 0;
        }else if (b>=m){
            return m;
        }
        return b*n/a;
    }
}
