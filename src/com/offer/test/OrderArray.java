package com.offer.test;

/*
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
* 分析：
* 方法一：
*   建立两个新的数组
*   按顺序取出奇数保存到数组1，偶数保存到数组2
*   两数组合并
* 方法二：
*   使用集合ArrayList,奇数添加到前面，偶数添加到后面，
*   用count记录奇数的个数从而确定添加奇数的位置
* */


import java.util.ArrayList;

public class OrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                list.add(array[i]);
            }else {
                list.add(count,array[i]);
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,5,3,7,2,4,8,4};
        OrderArray orderArray = new OrderArray();
        orderArray.reOrderArray(array);
    }
}
