package com.leetcode.DataStructure.array;

import java.util.Arrays;

public class moveZeroesSolution {
    public void moveZeroes(int[] nums) {
        //左指针左边均为非零数；
        //右指针左边直到左指针处均为零。
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if (nums[right] != 0){
                exch(nums,left,right);
                left += 1;
            }
            right += 1;
        }
    }

    private void exch(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
//        int[] nums = new int[]{1,0};
        moveZeroesSolution foo = new moveZeroesSolution();
        foo.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
