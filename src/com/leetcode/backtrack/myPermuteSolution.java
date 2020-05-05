package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class myPermuteSolution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> out = new LinkedList<>();
        int n = nums.length;
        ArrayList<Integer> nums_list = new ArrayList();
        for (int num : nums) {
            nums_list.add(num);
        }
        backTrack(n,nums_list,out,0);
        return out;
    }

    private void backTrack(int n, ArrayList<Integer> nums, List<List<Integer>> out, int first) {
        if (first==n){
            out.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums,first,i);
            backTrack(n,nums,out,first+1);
            Collections.swap(nums,first,i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        myPermuteSolution foo = new myPermuteSolution();
        List<List<Integer>> list = foo.permute(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
