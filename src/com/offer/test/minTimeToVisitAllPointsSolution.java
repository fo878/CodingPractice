package com.offer.test;
/*
平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
你可以按照下面的规则在平面上移动：
每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
必须按照数组中出现的顺序来访问这些点。

输入：points = [[1,1],[3,4],[-1,0]]
输出：7
解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
从 [1,1] 到 [3,4] 需要 3 秒
从 [3,4] 到 [-1,0] 需要 4 秒
一共需要 7 秒


* */
public class minTimeToVisitAllPointsSolution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length==0 || points.length==1){
            return 0;
        }
        int step = 0;
        int x = points[0][0];
        int y = points[0][1];
        int x_cur;
        int y_cur;
        for (int i = 0; i < points.length; i++) {
            x_cur = points[i][0];
            y_cur = points[i][1];
            step += Math.max(Math.abs(x_cur-x),Math.abs(y_cur-y));
            x = x_cur;
            y = y_cur;
        }
        System.out.println(step);
        return step;
    }

    public static void main(String[] args) {
        int[][] points =new int[][]{
                        {1,1},
                        {3,4},
                        {-1,0}
        };
        minTimeToVisitAllPointsSolution foo = new minTimeToVisitAllPointsSolution();
        System.out.println(foo.minTimeToVisitAllPoints(points));
    }

}
