package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/*
* 数组中数字出现的次数
* 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
* 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * */
public class singleNumbersSolution {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){//包含该元素将返回false
                set.remove((Integer) nums[i]);
            }
        }
        int[] res = new int[set.size()];
        int i =0;
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        singleNumbersSolution foo = new singleNumbersSolution();
        int[] ints = foo.singleNumbers(nums);
        System.out.println(Arrays.toString(ints));
    }
}
