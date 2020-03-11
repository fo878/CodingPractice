package com.leetcode.DataStructure.array;
/*
* 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
* 形式上，如果可以找出索引 i+1 < j 且满足 
* (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 
* 就可以将数组三等分。

分析：
* 通过数组求和，如果可以被三整除，则满足数组三等分的先决条件，得到subSum=Sum/3
* 因为数组中数字不能更换位置，所以要逐个遍历数组元素，检查是否能恰好分割到subSum
*
* */
class canThreePartsEqualSumSolution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum%3!=0){
            return false;
        }
        int subSum = sum/3;
//        System.out.println(subSum);
        int i=0,flag = 3;
        while (flag!=0 && i<A.length){
//            System.out.println(A[i]);
            subSum -= A[i++];
            if (subSum==0){
                flag-=1;
                subSum = sum/3;
            }
        }
        return subSum==0 || subSum==sum/3;
    }

    public static void main(String[] args) {
        int[] A = {3,3,6,5,-2,2,5,1,-9,4};
        int[] B = {0,2,1,-6,6,7,9,-1,2,0,1};
        int[] C = {12,-4,16,-5,9,-3,3,8,0};
        int[] D = {18,12,-18,18,-19,-1,10,10};
        canThreePartsEqualSumSolution foo = new canThreePartsEqualSumSolution();
        System.out.println(foo.canThreePartsEqualSum(A));//true
        System.out.println(foo.canThreePartsEqualSum(B));//false
        System.out.println(foo.canThreePartsEqualSum(C));//true
        System.out.println(foo.canThreePartsEqualSum(D));//true
    }
}
