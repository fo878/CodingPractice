package com.wrong;

import java.util.*;

/*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
*
* 输入: [3,30,34,5,9]
  输出: "3033459"
  *
  * 1.找到数组中最大的数的位数m
  * 2.复制一个新数组newNums，除最大数外，其它数的位数调整为m位，不足的后边补0
  * 3.把数组从小到大排列，把排列前的位置和排列后的位置记录在hashmap中
  * 4.按照排列后的位置，重新调整原数组的排序
  * 5.拼接调整后的数组并输出
 * */
public class minNumberSolution {

    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        minNumberSolution foo = new minNumberSolution();
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(foo.minNumber(nums));
    }
}
