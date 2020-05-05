package com.leetcode.DataStructure.array;
/*
* 在排序数组中查找数字 I
* 统计一个数字在排序数组中出现的次数。
* */
public class searchSolution {
    public int search(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                flag = true;
                count++;
            }else if (flag){
                return count;
            }
        }
        return count;
    }

    public int search1(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                flag = true;
                count++;
            }else if (flag){
                return count;
            }
        }
        return count;
    }

    /*
    *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。
    你的算法时间复杂度必须是 O(log n) 级别。
    * */
    public int search2(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[left] <= nums[mid]){
                if (target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (target<=nums[right] && target>nums[mid]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,7,8,0,1,2,3,4,5};
        int target = 1;
        searchSolution foo = new searchSolution();
        System.out.println(foo.search2(nums,target));
    }
}
