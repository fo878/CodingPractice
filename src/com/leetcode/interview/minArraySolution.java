package com.leetcode.interview;
/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  


class Solution:
    def minArray(self, numbers: List[int]) -> int:
        n = len(numbers)
        if n == 0:
            return 0
        for i in range(1,n):
            if numbers[i] < numbers[i-1]:
                return numbers[i]
        return numbers[0]

* */
public class minArraySolution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (n==0){
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
/*-------------------------------------------------*/
/*-------------二分法-------------------------------*/
    public int minArray1(int[] numbers) {
        if (numbers.length == 0) return 0;
        int l = 0, r = numbers.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if (numbers[mid] > numbers[r]) { // 肯定在后半截
                l = mid + 1;
            } else if (numbers[mid] == numbers[r]) {
                r = r - 1;
            } else {
                r = mid;
            }
        }
        return numbers[l];
    }
    /*----------------------------------------------*/

}
