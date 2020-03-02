package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
  完成所有替换操作后，请你返回这个数组。
* */
public class replaceElementsSolution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int max = 0;
            for (int j = i+1; j < arr.length; j++) {
                if (max<arr[j]){
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
        arr[arr.length-1] = -1;
        return arr;
    }

    /*精华题解*/
    /*
    * 从右往左，并始终维护一个当前位置右边的最大值 rightMaxrightMax，
    * 这样一来我们只需要遍历一遍数组。这样问题就转化为从右往左找最大值了。
    * */
    public int[] replaceElements2(int[] arr) {
        int rightMax = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = rightMax;
            if(temp > rightMax)
                rightMax = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElementsSolution foo = new replaceElementsSolution();
        int[] array = foo.replaceElements(arr);
        System.out.println(Arrays.toString(array));//{18,6,6,6,1,-1}
    }
}
