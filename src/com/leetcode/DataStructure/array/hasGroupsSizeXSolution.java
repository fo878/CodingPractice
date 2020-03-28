package com.leetcode.DataStructure.array;

import java.util.HashMap;
import java.util.Set;

/*
* 给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
* */
public class hasGroupsSizeXSolution {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<2){
            return false;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])){
                map.put(deck[i],map.get(deck[i])+1);
            }else {
                map.put(deck[i],1);
            }
        }
        int x = map.get(deck[0]);
        int max_gcd = x;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            max_gcd = gcd(max_gcd,map.get(key));
        }
        return max_gcd>=2;
    }

    public static int gcd(int a,int b){
        return b == 0? a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        int[] nums1 = new int[]{1,1,2,2,2,2};
        int[] nums2 = new int[]{1,2,2,2,2,2,2};
        System.out.println(hasGroupsSizeX(nums));
        System.out.println(hasGroupsSizeX(nums1));
        System.out.println(hasGroupsSizeX(nums2));
    }
}
