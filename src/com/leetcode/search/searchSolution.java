package com.leetcode.search;

public class searchSolution {
    //二分查找
    public int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (target<nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 13;
        searchSolution foo = new searchSolution();
        System.out.println(foo.search(nums,target));
    }
}
