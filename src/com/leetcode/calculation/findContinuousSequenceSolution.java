package com.leetcode.calculation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

    输入：target = 9
    输出：[[2,3,4],[4,5]]
* */
public class findContinuousSequenceSolution {
    public int[][] findContinuousSequence(int target) {
        int[] nums = new int[target];
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < target; i++) {
            nums[i] = i+1;
        }
        int i = 0, j = 0;
        int sum = 0;
        while(i<target) {
            sum = (nums[i] + nums[j]) * (j - i + 1) / 2;
            if (sum == target) {
                int[] array = Arrays.copyOfRange(nums,i,j+1);
                if (array.length>=2){
                    list.add(array);
                }
                i++;
            }else if (sum<target){
                j++;
            }else {
                i++;
            }
        }
        int[][] res = new int[list.size()][];
        int p = 0;
        for (int[] ints : list) {
            res[p++] = ints;
        }
        return res;
    }
    public static void main(String[] args) {
        findContinuousSequenceSolution foo = new findContinuousSequenceSolution();
        int[][] continuousSequence = foo.findContinuousSequence(10);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
