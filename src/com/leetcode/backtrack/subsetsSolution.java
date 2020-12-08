package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 78. 子集
*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
* */
public class subsetsSolution {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur+1,nums);
        t.remove(t.size()-1);
        dfs(cur+1, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        subsetsSolution foo = new subsetsSolution();
        List<List<Integer>> lists = foo.subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
