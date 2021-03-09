package com.leetcode.DataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class findDisappearedNumbersSolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] index = new int[n+1];
        index[0] = -1;
        for (int num : nums) {
            index[num] += 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (index[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        findDisappearedNumbersSolution foo = new findDisappearedNumbersSolution();
        System.out.println(foo.findDisappearedNumbers(nums));
    }
}