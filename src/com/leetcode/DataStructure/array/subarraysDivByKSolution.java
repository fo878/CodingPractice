package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 974. 和可被 K 整除的子数组
* 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class subarraysDivByKSolution {
    public int subarraysDivByK(int[] A, int K) {
        //以前缀和模 K 的值为key，出现的次数为值
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int elem : A) {
            preSum += elem;
            //Java取模的特殊性，当除数为负数时取模结果为负数，-7%3 = -1，-1+3=2， 2%3=2；
            int modulus = (preSum % K + K) % K;
            int same = map.getOrDefault(modulus,0);
            count += same;
            map.put(modulus,same+1);
        }
        System.out.println(Arrays.toString(map.keySet().toArray()));
        System.out.println(Arrays.toString(map.entrySet().toArray()));
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4,5,0,-2,-3,1};
        int K = 5;
        subarraysDivByKSolution foo = new subarraysDivByKSolution();
        System.out.println(foo.subarraysDivByK(A,K));
    }
}
