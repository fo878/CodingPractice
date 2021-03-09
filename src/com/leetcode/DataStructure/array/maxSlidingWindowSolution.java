package com.leetcode.DataStructure.array;

import java.util.*;

/*
* 面试题59 - I. 滑动窗口的最大值
* 239. 滑动窗口最大值
* 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:
n = 8
    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7]
    解释:

      滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

* */
public class maxSlidingWindowSolution {
    public int[] maxSlidingWindow1(int[] nums,int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[n-k+1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1] <= i-k) {
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[]{};
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] maxNums = new int[nums.length-k+1];
        maxNums[0] = Integer.MIN_VALUE;//初始化队列
        for (int i = 0; i < k; i++) {
            if (nums[i]>maxNums[0]){
                maxNums[0] = nums[i];
            }
            queue.add(nums[i]);
        }
        for (int i = 1; i <= nums.length-k; i++) {
            queue.add(nums[i+k-1]);
            Integer poll = queue.poll();
            if (poll == maxNums[i-1]){
                //重新计算队列的最大值
                int newMax = Integer.MIN_VALUE;
                for (int j = i; j < i+k; j++) {
                    if (nums[j] > newMax){
                        newMax = nums[j];
                    }
                }
                maxNums[i] = newMax;
            }else {
                if (nums[i+k-1]>maxNums[i-1]){
                    maxNums[i] = nums[i+k-1];
                }else maxNums[i] = maxNums[i-1];
            }
        }
        return maxNums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindowSolution foo = new maxSlidingWindowSolution();
        System.out.println(Arrays.toString(foo.maxSlidingWindow1(nums,k)));
    }
}
