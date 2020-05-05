package com.leetcode.greedy;
/*
* 45. 跳跃游戏 II
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class jumpSolution {
    public static int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int maxPosition = 0;
        /*
        * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
        * 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        * 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，
        * 因此我们不必访问最后一个元素。
        * */
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i==end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,1,1,4};
        System.out.println(jump(in));
    }
}
