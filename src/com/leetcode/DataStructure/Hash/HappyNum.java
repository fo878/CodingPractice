package com.leetcode.DataStructure.Hash;

import java.util.HashSet;
import java.util.Set;

/*
* 编写一个算法来判断一个数是不是“快乐数”。
* 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
* 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
*
* 分析：将每次的计算结果保存到一个set中，如果出现重复数字，则说明它不是快乐数
 * */
public class HappyNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1){
            n = change(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        int num;
        while(n != 0){
            num = n%10;
            n /= 10;
            sum += num*num;
        }
        return sum;
    }
}


