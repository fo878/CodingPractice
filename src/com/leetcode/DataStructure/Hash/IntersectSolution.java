package com.leetcode.DataStructure.Hash;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 给定两个数组，编写一个函数来计算它们的交集v2
*
* 说明：
*  输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
*  我们可以不考虑输出结果的顺序。
* */
public class IntersectSolution {
    public int[] intersect(int[] nums1, int[] nums2) {//假设nums1比nums2短
        if (nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        //把长的nums2存入集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> outlist = new ArrayList<Integer>();
        for (int e : nums2) {
            list.add(e);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (list.contains(nums1[i])){
                outlist.add(nums1[i]);
                list.remove(list.indexOf(nums1[i]));//找到一个删一个，不删的话，nums2中的一个可能对应nums1中多个
            }
        }
        int[] res = new int[outlist.size()];
        Object[] objects = outlist.toArray();
        for (int i = 0; i < outlist.size(); i++) {
            res[i] = (int) objects[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums2 = {4,9,5};
        int[] nums1 = {9,4,9,8,4};
        IntersectSolution foo = new IntersectSolution();
        System.out.println(Arrays.toString(foo.intersect(nums1,nums2)));
    }
}
