package com.saima.inspur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，
* 且不存在两个石头有相同的半径。为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
* 因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
* 问最少需要操作多少次才能将这n个石头的半径变成升序？
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1);
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int[] numssorted = new int[n];
        numssorted = nums.clone();
        Arrays.sort(numssorted);
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == numssorted[j]){
                ++count;
                ++j;
            }
        }
        System.out.println(n-count);
    }
}
