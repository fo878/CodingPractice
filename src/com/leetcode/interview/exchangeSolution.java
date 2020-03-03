package com.leetcode.interview;

import java.util.Arrays;

/*
* 调整数组顺序使奇数位于偶数前面
*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
* */
public class exchangeSolution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int tmp = 0;
        while (i<j){
            if (nums[i]%2==1) i++;
            else if (nums[j]%2==0) j--;
            else {
                tmp = nums[j];
                nums[j--] = nums[i];
                nums[i++] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        exchangeSolution foo = new exchangeSolution();
        System.out.println( Arrays.toString(foo.exchange(nums)));
    }
}
