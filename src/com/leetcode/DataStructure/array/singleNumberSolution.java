package com.leetcode.DataStructure.array;

import java.util.HashMap;

/*
* 数组中数字出现的次数 II
* 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * */
public class singleNumberSolution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)==1){
                return integer;
            }
        }
        return 0;
    }
}
