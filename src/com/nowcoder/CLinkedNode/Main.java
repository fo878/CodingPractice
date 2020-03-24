package com.nowcoder.CLinkedNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
/*
* 检查单向链表是否存在环，若存在环则返回环的长度，否则返回0。

要求：算法实现尽可能做到时间、空间复杂度最优。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String subline = line.substring(1,line.length()-1);
        char[] chars = subline.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>='0' && chars[i]<='9'){
                sb.append(chars[i]);
            }
        }
        String s = sb.toString();
        char[] ch = s.toCharArray();
        int[] nums = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            nums[i] = ch[i]-'0';
        }
        int[] array1 = new int[s.length()/2];
        int[] array2 = new int[s.length()/2];
        int j = 0,k=0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2==0){
                array1[j++] = nums[i];
            }else array2[k] = nums[i];
        }
        Main foo = new Main();
        System.out.println(foo.count(array1,array2));
    }

    public int count(int[] array1,int[] array2){
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            set.add(array1[i]);
            ans++;
            if(!set.add(array2[i])){
                return ans;
            }
        }
        return 0;
    }
}
