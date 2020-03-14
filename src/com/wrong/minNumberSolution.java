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
        if (nums.length == 0){
            return "";
        }
//        1.找到数组中最大的数的位数m
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num>max){
                max = num;
            }
        }
        int m = digits(max);
//        2.复制原数组到一个新数组newNums，除最大数外，其它数的位数调整为m位，不足的后边补0
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int[] newNums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            while (digits(newNums[i]) != m){
                newNums[i] = newNums[i]*10;
            }
            map.put(Integer.toString(nums[i]),newNums[i]);
        }
//        3.根据值的大小给键排序;
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue() - o2.getValue());
            }
        });
//        4.排列后的顺序
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> integerEntry : list) {
            sb.append(integerEntry.getKey());
        }
//        5.拼接调整后的数组并输出
        return sb.toString();
    }

    public int digits(int num){
        int m = 0;
        while (num>0){
            m++;
            num = num/10;
        }
        return m;
    }

    public static void main(String[] args) {
        minNumberSolution foo = new minNumberSolution();
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(foo.minNumber(nums));
    }
}
