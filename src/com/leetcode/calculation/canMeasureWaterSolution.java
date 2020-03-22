package com.leetcode.calculation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
*有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
*
* 方法一：
*   数学方法：贝祖定理+欧几里得算法（辗转相除法）
*   ax+by = z有解当且仅当 z是gcd(x,y)的整数倍
*
* 方法二：深度优先搜索
* */

public class canMeasureWaterSolution {
    /*----------------数学方法-------------*/
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y<z) return false;
        if (x==0 || y==0){
            return z==0 || x+y==z;
        }
        return z % gcd(x,y) == 0;
    }
    int gcd(int a,int b){
        if (b==0) return a;
        int r = a%b;
        return gcd(b,r);
    }

    /*---------------DFS--------------------*/
    public boolean canMeasureWater1(int x, int y, int z) {
        //1.边界判断
        if (x + y < z || z < 0) return false;
        //2.存放所有可能的状态,并用来防止重复进入同一状态
        Set<Integer> set = new HashSet<>();
        //3.存放当前存活的各种状态
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            //1.将x灌满;(curr + x <= x + y -->说明curr<=y,可以将curr 全部放入 y 中,x此时为空)
            if (curr + x <= x + y && set.add(curr + x))
                queue.offer(curr + x);
            //2.将y灌满
            if (curr + y <= x + y && set.add(curr + y))
                queue.offer(curr + y);
            //3.将x清空
            if (curr - x >= 0 && set.add(curr - x))
                queue.offer(curr - x);
            //4.将y清空
            if (curr - y >= 0 && set.add(curr - y))
                queue.offer(curr - y);
            if (set.contains(z))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 36;
        int x = 0, y = 0, z = 0;
        canMeasureWaterSolution foo = new canMeasureWaterSolution();
        System.out.println(foo.canMeasureWater(x,y,z));
    }
}
