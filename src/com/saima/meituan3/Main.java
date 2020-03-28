package com.saima.meituan3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
一个序列是有趣的需要满足：当且仅当这个序列的每一个元素ai 满足 i 整除ai 。
现在给定一个长度为n的数组，问这个数组有多少个非空的子序列是有趣的，
由于答案可能比较大，只需要输出在模998244353意义下答案的就行了。
一个长度为n的数组的非空子序列定义为从这个数组中移除至多n-1个元素后剩下的元素有序按照原顺序形成的数组。
比如说对于数组[3,2,1]，它的非空子序列有[3],[2],[1],[3,2],[3,1],[2,1],[3,2,1]。
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line2 = br.readLine();
        String[] strings = line2.trim().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int count = 0;//统计子序列是有趣的个数
        //求所有子序列
        List<List<Integer>> list = subsets(nums);
        for (List<Integer> iList : list) {
            int[] arrays = new int[iList.size()];
            for (int i = 0; i < arrays.length; i++) {
                arrays[i] = iList.get(i);
            }
            if (isfun(arrays)) count++;
        }
        System.out.println(count%998244353);
    }

    private static boolean isfun(int[] nums){
        //判断该子数组为有趣的
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % (i+1) != 0){
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
