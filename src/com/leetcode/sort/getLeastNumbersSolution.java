package com.leetcode.sort;

import java.util.Arrays;

/*最小的k个数
* 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * */
public class getLeastNumbersSolution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,0,k);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;
        getLeastNumbersSolution foo = new getLeastNumbersSolution();
        int[] numbers = foo.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(numbers));
    }
}
