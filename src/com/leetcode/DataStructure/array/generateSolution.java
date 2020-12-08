package com.leetcode.DataStructure.array;

/*
* 118. 杨辉三角
* */


import java.util.ArrayList;
import java.util.List;

public class generateSolution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i ; ++j) {
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }


    public static void main(String[] args) {
        generateSolution foo = new generateSolution();
        List<List<Integer>> res = foo.generate(5);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
