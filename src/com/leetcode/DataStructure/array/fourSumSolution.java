package com.leetcode.DataStructure.array;

import java.util.*;

/*
* 18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class fourSumSolution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums==null || nums.length<4){
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-3; i++) {
            //第一重循环
            if (i>0 && nums[i] == nums[i-1]){//避免重复四元组
                continue;
            }
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){//后面的都比目标值大，不用找了
                break;
            }
            if (nums[i] + nums[length-3] + nums[length-2] + nums[length-1] < target){
                continue;
            }
            //第二重循环
            for (int j = i+1; j < length-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]){//避免重复四元组
                    continue;
                }
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target){//在确定第一个数是nums[i]时，后面的都比目标值大，不用找了
                    break;
                }
                if (nums[i] + nums[j] + nums[length-2] + nums[length-1] < target){
                    continue;
                }
                int left = j+1, right = length-1;
                while (left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        quadruplets.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        fourSumSolution foo = new fourSumSolution();
        List<List<Integer>> lists = foo.fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
