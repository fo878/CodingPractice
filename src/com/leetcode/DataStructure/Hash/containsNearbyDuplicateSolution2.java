package com.leetcode.DataStructure.Hash;

import java.util.*;

/*
* 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums[i] = nums[j]，并且i和j的差的绝对值最大为 k。
*
* 存在这样的（i,j）满足 nums[i] == nums[j] && abs(i - j) <= k 只要存在这样的index对 就满足条件并返回true
* 分析：
*   遍历数组，对于每个元素做以下操作：
*   在散列表中搜索当前元素，如果找到了就返回 true。
*   在散列表中插入当前元素。
*   如果当前散列表的大小超过了 k， 删除散列表中最旧的元素。
* */
public class containsNearbyDuplicateSolution2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        containsNearbyDuplicateSolution2 foo = new containsNearbyDuplicateSolution2();
        System.out.println(foo.containsNearbyDuplicate(nums,k));
    }
}
