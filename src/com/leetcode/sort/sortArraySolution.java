package com.leetcode.sort;
/*
* 给你一个整数数组 nums，请你将该数组升序排列。
* */

import java.util.Arrays;

public class sortArraySolution {
    public int[] sortArray(int[] nums) {
        sortArray(nums,0,nums.length-1);
        return nums;
    }

    private static void sortArray(int[] nums,int lo,int hi){
        if (hi<=lo){
            return;
        }
        int j = partition(nums,lo,hi);
        sortArray(nums,lo,j-1);
        sortArray(nums,j+1,hi);
    }

    private static int partition(int[] nums,int lo,int hi){
        int i = lo,j = hi+1;
        int v = nums[lo];
        while(true) {
            while (nums[++i] < v) {
                if (i == hi) break;
            }
            while (v < nums[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(nums,i,j);
        }
        exch(nums,lo,j);
        return j;
    }

    private static void exch(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        sortArraySolution foo = new sortArraySolution();
        int[] array = foo.sortArray(nums);
        System.out.println(Arrays.toString(array));
    }
}
