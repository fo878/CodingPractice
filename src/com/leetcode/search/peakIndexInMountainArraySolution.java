package com.leetcode.search;

public class peakIndexInMountainArraySolution {
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        int l = 0;
        int r = len-1;
        int mid;
        while (l<r){
            mid = l+(r-l)/2;
            if (A[mid]<A[mid+1]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1,0};
        peakIndexInMountainArraySolution foo = new peakIndexInMountainArraySolution();
        System.out.println(foo.peakIndexInMountainArray(nums));
    }
}
