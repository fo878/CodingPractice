package com.leetcode.backtrack;

/*
* 47. 全排列 II
*给定一个可包含重复数字的序列，返回所有不重复的全排列。
*
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
* */


import java.util.*;

public class permuteUniqueSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len==0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        //因为有重复元素，先对nums进行排序
        Arrays.sort(nums);
        //使用过
        boolean[] used = new boolean[len];

        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums,len,0,used,path,res);
        return res;
    }

    private void dfs(int[] nums,
                     int len,
                     int depth,
                     boolean[] used,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (depth==len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums,len,depth+1,used,path,res);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        permuteUniqueSolution foo = new permuteUniqueSolution();
        System.out.println(foo.permuteUnique(nums));
    }
}
