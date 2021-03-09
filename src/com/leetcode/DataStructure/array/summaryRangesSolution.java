package com.leetcode.DataStructure.array;

import java.util.ArrayList;
import java.util.List;
/*
228. 汇总区间
给定一个无重复元素的有序整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b
* */
class summaryRangesSolution {
    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0,j = 0;
        int a,cur,b;
        while(i<n && j<n) {
            a = nums[i];
            cur = a;
            while (j<n && nums[j] == cur) {
                j += 1;
                cur += 1;
            }
            b = nums[j-1];
            if (a != b){
                res.add(a + "->" + b);
            } else {
                res.add(Integer.toString(a));
            }
            i=j;
        }
        return res;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0,j = 0;
        int cur;
        while(i<n) {
            cur = nums[i];
            while (j<n && nums[j] == cur) {
                j += 1;
                cur += 1;
            }
            if (nums[i] != nums[j-1]){
                res.add(nums[i] + "->" + nums[j-1]);
            } else {
                res.add(Integer.toString(nums[i]));
            }
            i=j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2,4,5,7};
        int[] nums2 = new int[]{0,2,3,4,6,8,9};
        int[] nums3 = new int[]{};
        int[] nums4 = new int[]{-1};
        int[] nums5 = new int[]{0};
        summaryRangesSolution foo = new summaryRangesSolution();
        System.out.println(foo.summaryRanges(nums1).toString());
        System.out.println(foo.summaryRanges(nums2).toString());
        System.out.println(foo.summaryRanges(nums3).toString());
        System.out.println(foo.summaryRanges(nums4).toString());
        System.out.println(foo.summaryRanges(nums5).toString());
    }
}