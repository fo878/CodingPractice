package com.saima.inspur2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
* 某条街道两侧分别种植了一排树木，并按如下编号：
1 3 5 7 .... 45 47 49 ... 99
2 4 6 8 ... 46 48 50 ... 100
但是有一些树被砍去，希望你能找出一边最长的连续的大树。

input:
第一行一个整数N
第二行N个整数表示被砍去树的编号
output:
M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1);
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] nums = new int[strings.length];
        ArrayList list = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
            list.add(nums[i]);
        }
        ArrayList treelist1 = new ArrayList();
        ArrayList treelist2 = new ArrayList();
        for (int i = 1; i < 101; i++) {
            if (list.contains(i)) continue;
            if (i%2 == 1){
                treelist1.add(i);
            }else{
                treelist2.add(i);
            }
        }
        int[] nums1 = new int[treelist1.size()];
        int[] nums2 = new int[treelist2.size()];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = (int)treelist1.get(i);
            nums2[i] = (int)treelist2.get(i);
        }
        int count1 = 0;
        int count2 = 0;
        count1 = longestConsecutive(nums1);
        count2 = longestConsecutive(nums2);
        int res = Math.max(count1,count2);
        System.out.println(res);
    }

    private static boolean arrayContains(int[] arr,int num){
        for (int i = 0; i < arr.length; i = i+2) {
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

    public static int longestConsecutive(int[] nums){
        int longest = 0;
        for (int num : nums) {
            int curNum = num;
            int curst = 1;
            while(arrayContains(nums,curNum + 1)){
                curNum++;
                curst++;
            }
            longest = Math.max(longest,curst);
        }
        return longest;
    }
}
