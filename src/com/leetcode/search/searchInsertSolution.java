package com.leetcode.search;

public class searchInsertSolution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        int mid=0;
        while(left<right){
            mid = (left+right)>>>1;
            if (nums[mid]<target){
                left = mid+1;
            }else if (nums[mid] == target){
                return mid;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        searchInsertSolution foo = new searchInsertSolution();
        System.out.println(foo.searchInsert(nums,target));
    }
}
