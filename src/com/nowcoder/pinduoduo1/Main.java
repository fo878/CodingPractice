package com.nowcoder.pinduoduo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
描述：
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int N = Integer.parseInt(first);
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(solution(nums,N));
        //测试
//        System.out.println("N:" + N);
//        System.out.println(Arrays.toString(nums));
    }

    private static int solution(int[] nums,int N){
        int sum1 = 0;
        if (N<=2){
            for (int i = 0; i < nums.length; i++) {
                sum1 += nums[i];
            }
            return sum1;
        }
        Arrays.sort(nums);
        int j = 0,res = 0;
        for (int i = N-1; i >= 0 ; i--) {
            j++;
            if (j%3!=0){
                res += nums[i];
            }
        }
        return res;
    }
}
