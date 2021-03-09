package com.leetcode.DataStructure.array;

/*
* 189. 旋转数组
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* */
public class rotate189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[(i+k)%n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = array[i];
        }
    }

    public void rotate1(int[] nums,int k) {
        //1 2 3 4 5 6 7  k=3
        //7 6 5 4 3 2 1  0 到 k mod n-1 翻转
        //5 6 7 4 3 2 1  k mod n 到 n-1 翻转
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }


}
