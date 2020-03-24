package com.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort {
    //插入排序、冒泡排序、希尔排序
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        Sort foo = new Sort();
        System.out.println(Arrays.toString(foo.sort1(num)));
    }

    private int[] sort1(int[] num) {
        //插入排序insertion sort
        int temp;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];//待插入数据
            int j;
            for (j = i - 1; j >= 0; j--) {
                //判断是否大于temp，大于则后移一位
                if (num[j] > temp) {
                    num[j + 1] = num[j];
                } else break;
            }
            num[j + 1] = temp;
        }
        return num;
    }
    
    private int[] sort2(int[] num){
        //选择排序  冒泡排序
        int n = num.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (num[j] < num[min]){
                    min = j;
                }
            }
            int tmp = num[i];
            num[i] = num[min];
            num[min] = tmp;
        }
        return num;
    }

    private int[] sort3(int[] num){
        //希尔排序
        int n = num.length;
        int h = 1;
        while(h<n/3){
            h = 3*h+1;
        }
        while(h>=1){
            //将数组变为h有序
            for(int i = h;i<n;i++){
                //将num[i]插入到num[i-h] num[i-2*h] num[i-3h]中
                for (int j=i;j>=h && num[j]<num[j-h];j-=h){
                    int tmp = num[j];
                    num[j] = num[j-h];
                    num[j-h] = tmp;
                }
            }
            h /= 3;
        }
        return num;
    }
}
