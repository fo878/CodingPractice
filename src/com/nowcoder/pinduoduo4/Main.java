package com.nowcoder.pinduoduo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
描述：
多多的方框游戏，有K个可以替换的机会，找出最长的连续子串
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int N = Integer.parseInt(strings[0]);
        int K = Integer.parseInt(strings[1]);
        line = br.readLine();
        strings = line.trim().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(solution(nums,K));
        //测试
//        System.out.println("N:" + N);
//        System.out.println("K:" + K);
//        System.out.println(Arrays.toString(nums));
    }

    private static int solution(int[] nums,int K){
        //有K个可以替换的机会，找出最长的连续子串
        ArrayList<Integer> list = new ArrayList<Integer>();//用来保存颜色的最长子串的长度
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int cur = nums[i];
            int l = 1;
            while (j<nums.length){
                if (cur==nums[j]){
                    l++;
                }else if (K>0){
                    K--;
                }else {
                    list.add(l);
                    l = 0;
                    break;
                }
                j++;
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
