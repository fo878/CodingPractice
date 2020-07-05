package com.leetcode.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
*378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
*
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
* */
public class kthSmallestSolution {

    /*
    * 由题目给出的性质可知，这个矩阵的每一行均为一个有序数组。
    * 问题即转化为从这 n 个有序数组中找第 k 大的数，可以想到利用归并排序的做法，归并到第 k 个数即可停止。
      一般归并排序是两个数组归并，而本题是 n 个数组归并，所以需要用小根堆维护，以优化时间复杂度。
    * */
    public static int kthSmallest1(int[][] matrix, int k) {
        Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //小根堆中保存的是整形矩阵，排列顺序按照矩阵的首元素大小，小的在前面
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int n = matrix.length;//n行矩阵
        for (int i = 0; i < n; i++) {
            //小根堆中保存的矩阵，{矩阵第i行的首个元素，第i行，0}
            heap.offer(new int[]{matrix[i][0],i,0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] now = heap.poll();
            if (now[2] != n - 1) {
                heap.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return heap.poll()[0];
    }

    /*
    可以这样描述走法：
        初始位置在 matrix[n - 1]（即左下角）；
        设当前位置为 matrix[i][j]。若 matrix[i][j]≤mid，则将当前所在列的不大于 mid 的数的数量（即 i + 1）累加到答案中，并向右移动，否则向上移动；
        不断移动直到走出格子为止。
        我们发现这样的走法时间复杂度为 O(n)，即我们可以线性计算对于任意一个 mid，矩阵中有多少数不小于它。这满足了二分答案的性质。
        不妨假设答案为 x，那么可以知道 l≤x≤r，这样就确定了二分答案的上下界。
        每次对于「猜测」的答案 mid，计算矩阵中有多少数不大于 mid ：
        如果数量不多于 k，那么说明最终答案 x 不小于 mid；
        如果数量少于 k，那么说明最终答案 x 大于 mid。
        这样我们就可以计算出最终的结果 x 了。
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;//矩阵行数
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left<right){
            int mid = left + ((right-left)>>1);
            if (check(matrix,mid,k,n)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;//更新计数
                j++;//右移
            } else {
                i--;//上移
            }
        }
        return num >= k;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,  5,  9},
                { 10,  11, 13},
                { 12,  13,  15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix,k));
    }
}
