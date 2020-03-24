package com.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] num){
        sort(num,0,num.length-1);
        return num;
    }
    private static void sort(int[] num,int lo,int hi){
        if (hi<=lo) return;
        int j = partition(num,lo,hi);
        sort(num,lo,j-1);
        sort(num,j+1,hi);
    }
    private static int partition(int[] num,int lo,int hi){
        int i = lo,j = hi+1;
        int v = num[lo];
        while(true) {
            while (num[++i] < v) {
                if (i == hi) break;
            }
            while (v < num[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(num,i,j);
        }
        exch(num,lo,j);
        return j;
    }

    private static void exch(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        QuickSort foo = new QuickSort();
        System.out.println(Arrays.toString(foo.sort(num)));
    }
}
