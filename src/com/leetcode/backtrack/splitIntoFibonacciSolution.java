package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//842. 将数组拆分成斐波那契序列
public class splitIntoFibonacciSolution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list,S,S.length(),0,0,0);
        return list;
    }

    public boolean backtrack(List<Integer> list,String S,int length,int index,int sum,int prev){
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i>index && S.charAt(index)=='0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int)currLong;
            if (list.size()>=2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list,S,length,i+1,prev+curr,curr)) {
                return true;
            } else {
                list.remove(list.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] SArray = new String[5];
        SArray[0] = "123456579";
        SArray[1] = "11235813";
        SArray[2] = "112358130";
        SArray[3] = "0123";
        SArray[4] = "1101111";
        splitIntoFibonacciSolution foo = new splitIntoFibonacciSolution();
        for (int i = 0; i < SArray.length; i++) {
            List<Integer> list = foo.splitIntoFibonacci(SArray[i]);
            System.out.println(list.toString());
        }

    }
}
