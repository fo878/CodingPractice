package com.leetcode.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    //归并排序
    private int[] sort(int[] num){
        mergeSort(num,0,num.length-1);
        return num;
    }
    public static void mergeSort(int[]  num, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort( num, low, mid);//左边
            mergeSort( num, mid + 1, high);//右边
            merge( num, low, mid, high);//左右归并
        }
    }

    /**
     * 归并排序
     *
     * @param  num
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[]  num, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if ( num[i] < num[j]) {
                temp[k++] =  num[i++];
            } else {
                temp[k++] =  num[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] =  num[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] =  num[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            num[k2 + low] = temp[k2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] num = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            num[i] = Integer.parseInt(strings[i]);
        }
        MergeSort foo = new MergeSort();
        System.out.println(Arrays.toString(foo.sort(num)));
    }
}
