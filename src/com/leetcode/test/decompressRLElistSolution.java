package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 给你一个以行程长度编码压缩的整数列表 nums 。
考虑每对相邻的两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
请你返回解压后的列表。
* */
public class decompressRLElistSolution {
    public int[] decompressRLElist(int[] nums) {
        int i = 0;
        int j = 1;
        ArrayList out = new ArrayList();
        while (j<nums.length){
            for (int k = 0; k < nums[i]; k++) {
                out.add(nums[j]);
            }
            i=i+2;
            j=j+2;
        }
        int[] res = new int[out.size()];
        Object[] array = out.toArray();
        for (int k = 0; k < res.length; k++) {
            res[k] = (int)array[k];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        decompressRLElistSolution foo = new decompressRLElistSolution();
        int[] out = foo.decompressRLElist(nums);
        System.out.println(Arrays.toString(out));
    }
}
