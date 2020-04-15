package com.nowcoder.pinduoduo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/*
描述：


* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int N = Integer.parseInt(strings[0]);
        int K = Integer.parseInt(strings[1]);
        int num = Integer.parseInt(br.readLine());
        StringBuffer ans = new StringBuffer(num);
        System.out.print(solution(num,N,K,ans) + " " + ans);
//        System.out.println("N:" + N);
//        System.out.println("K:" + K);
//        System.out.println(num);
    }
    private static int solution(int num,int N,int K,StringBuffer ans){
        String s = Integer.toString(num);
        int mean = 0,sum = 0;
        char[] chars = s.toCharArray();
        TreeMap<Character,Integer> map = new TreeMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        Character character = map.lastKey();
        mean = (char)character-'0';
        int res=0;
        for (int i = 0; i < chars.length; i++) {
            if (K>0){
                res += Math.abs(chars[i]-'0' - mean);
                ans.setCharAt(i,(char)(mean+'0'));
                K--;
            }else {
                return res;
            }
        }
        return res;
    }
}
