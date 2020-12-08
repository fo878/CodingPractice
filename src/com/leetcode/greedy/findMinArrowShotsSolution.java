package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShotsSolution {
    public int findMinArrowShots(int[][] points) {
        // 1. 特判
        if(points.length == 0){
            return 0;
        }

         //2. 对数组按照右边界排序
         Arrays.sort(points,new Comparator<int[]>(){
             public int compare(int[] point1,int[] point2) {
                 return point1[1] < point2[1] ? -1:1;
             }
         });

        // 2. 对数组按照右边届排序（使用lambda）
        //Arrays.sort(points,(a, b) -> Integer.compare(a[1],b[1]));

        // 3. 贪心射箭
        int pos = points[0][1];     // 当前箭的射出位置
        int ans = 1;                // 初始化射箭的数量为1
        for(int[] balloon:points){  // 遍历所有气球🎈
            if(balloon[0] > pos){   // 找出右边界位置最靠左的气球🎈（如果有左边界小于当前的，说明可以一起射爆）
                pos = balloon[1];   // 更新右边界：下一只箭射出的位置
                ++ans;              // 射爆
            }
        }
        return ans;
    }
}