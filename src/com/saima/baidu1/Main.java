package com.saima.baidu1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
* 乘法表：
* 度度熊和爷爷在玩一个乘法表游戏。乘法表的第i行第j列位置的元素为i*j，
* 并且乘法表下标编号从1开始，比如2 × 3乘法表为
1 2 3
2 4 6
爷爷十分聪明，对于n*m的乘法表，只要度度熊给出一个数k，
* 爷爷就能立刻告诉度度熊乘法表中元素按照不减顺序排列之后，第k个元素是多少。你能重复这个游戏吗？
*
* input：
* 输入数据是三个整数：n, m, k (1≤n, m≤5*105, 1≤k≤nm)。
* output：
* 输出n*m乘法表按照不减顺序排列的第k个数。
*
* 分析：此题为topK问题的变形：
二分法的情况下
1.由于该乘法表大小为n*m,因此可以计算出最大值为n*m,而最小值为0，那么mid = n*m+0。
2.然后根据mid划分出大于mid的集合和小于mid的集合。
3.如果小于mid的集合数量大于k那么就设置最大值为mid-1，并递归查找。
4.如果小于mid的集合数量小于k那么就设置最小值为mid+1，并递归查找。
以上二分法在此题环境下可以轻松判定出小于或大于mid的集合数量，因为乘法表是递增的。
而在一般情况下则需要使用与快速排序相似的方法进行划分。

使用堆的情况下
1.将乘法表前k个数置于一个最大堆中。
2.将乘法表的后续数依此与最大堆中的顶端值进行比较，如果乘法表当前值小于顶端值则删除顶端值并插入当前值，
  然后调整堆使其满足最大堆条件。
3.最终堆的顶端值便第k个小的值。
以上堆排序解法虽然能够解答该问题，但是在k为极大的值的时候，堆的调整开销也会变得巨大，
* 因此时间效率会下降。因此在不涉及源数组不能改变以及海量数据的topk问题的情况下，考虑使用第一种解答方法。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int k = Integer.parseInt(strings[2]);
        long res = topK2(n,m,k);
        System.out.println(res);
    }

    private static int topK1(int n,int m,int k){
        //常规方法排序超出时间限制
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add((i+1)*(j+1));
            }
        }
        Collections.sort(list);
        return (int)list.get(k-1);
    }

    private static long topK2(long n,long m,long k){
    /*
    二分法的情况下
    1.由于该乘法表大小为n*m,因此可以计算出最大值为n*m,而最小值为0，那么mid = n*m+0。
    2.然后根据mid划分出大于mid的集合和小于mid的集合。
    3.如果小于mid的集合数量大于k那么就设置最大值为mid-1，并递归查找。
    4.如果小于mid的集合数量小于k那么就设置最小值为mid+1，并递归查找。
    以上二分法在此题环境下可以轻松判定出小于或大于mid的集合数量，因为乘法表是递增的。
    而在一般情况下则需要使用与快速排序相似的方法进行划分。
    */
        long left = 0;
        long right =m*n;
        long mid = right/2;
        while(left<=right){
            mid = (left+right)/2;
            if(calSum(mid,m,n)<k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }


    public static long calSum(long k, long m, long n){
        long sum = 0;
        for(int i=1; i<=m; i++){
            sum += (k>=n*i)?n:k/i;
        }
        return sum;
    }
}
