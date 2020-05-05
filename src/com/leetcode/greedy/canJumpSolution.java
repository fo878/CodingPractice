package com.leetcode.greedy;

import java.util.Arrays;

/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class canJumpSolution {
    public static boolean canJump1(int[] nums) {
        //递归法，超时
        if (nums.length==0 || nums.length==1){
            return true;
        }
        int a = nums[0];
        boolean flag = false;
        for (int i = 1; i < a+1 && i<nums.length; i++) {
            int[] subnums = Arrays.copyOfRange(nums,i,nums.length);
            flag = flag || canJump1(subnums);
        }
        return flag;
    }

    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,1,1,4};
        int[] in1 = new int[]{3,2,1,0,4};
        int[] in2 = new int[]{1,3,2};
        int[] in3 = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,
                2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,
                5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,
                2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(canJump(in));
        System.out.println(canJump(in1));
        System.out.println(canJump(in2));
        System.out.println(canJump(in3));
    }
}
