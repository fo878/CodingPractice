package com.leetcode.DataStructure.array;
/*
* 在排序数组中查找数字 I
* 统计一个数字在排序数组中出现的次数。
* */
public class searchSolution {
    public int search(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                flag = true;
                count++;
            }else if (flag){
                return count;
            }
        }
        return count;
    }

    public int search1(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                flag = true;
                count++;
            }else if (flag){
                return count;
            }
        }
        return count;
    }
}
