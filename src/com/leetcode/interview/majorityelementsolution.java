package com.leetcode.interview;

import java.util.HashMap;
import java.util.HashSet;

/*
* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
* 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* */
public class majorityelementsolution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int n = nums.length;
        if (n==1){
            return nums[0];
        }
        HashMap<Integer,Integer> map = new HashMap();//key为元素，value为该元素在数组中的数量
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                int value = map.get(nums[i])+1;
                map.put(nums[i],value);
                if (value>(n/2)){
                    return nums[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1};
        majorityelementsolution foo = new majorityelementsolution();
        System.out.println("多数元素是：" + foo.majorityElement(array));
    }
}
