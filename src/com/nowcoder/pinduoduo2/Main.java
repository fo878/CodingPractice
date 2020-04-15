package com.nowcoder.pinduoduo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
描述：

input：
1
3 1
1  2  5
10 11 6
12 12 7

第一行，T组测试数据，
第二行，n=3矩阵的大小，k=1每一步最多能走多少个格子
接下来n行，每一行n个数代表矩阵A的元素

output：
37 = 1+2+5+6+11+12
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        line = br.readLine();
        strings = line.trim().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(calculator(nums,M,N));
        //测试
//        System.out.println("M:" + M);
//        System.out.println("N:" + N);
//        System.out.println(Arrays.toString(nums));
    }

    private static int calculator(int[] nums,int M,int n){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%M==0){
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] subNums = Arrays.copyOfRange(nums,i,j+1);
//                System.out.println(Arrays.toString(subNums));
                if (isRight(subNums,M)){
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isRight(int[] nums,int M){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % M == 0;
    }
}
