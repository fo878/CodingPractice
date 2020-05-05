package com.leetcode.play20200418;

import java.util.Arrays;

/*
3. 剧情触发时间
在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），
资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。
这个二维数组的每个元素是一个长度为 3 的一维数组，
例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
所有剧情的触发条件也用一个二维数组 requirements 表示。
这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，
如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。
如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
* */
class Solution3 {
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = requirements.length;
        int[] source = new int[]{0,0,0};
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for (int i = 0; i < requirements.length; i++) {
            if (tag(source,requirements[i]) && res[i]==-1){
                res[i] = 0;
            }
        }

        for (int time = 0; time < increase.length; time++) {
            source = sum(increase[time],source);
//            System.out.println(Arrays.toString(source));
            for (int i = 0; i < requirements.length; i++) {
                if (tag(source,requirements[i]) && res[i]==-1){
                    res[i] = time+1;
                }
            }
        }
        return res;
    }

    public static int[] sum(int[] a,int[] b){
        //求两个相等长度矩阵的和
        for (int i = 0; i < a.length; i++) {
            b[i] = b[i] + a[i];
        }
        return b;
    }

    public static boolean tag(int[] a,int[] b){
        //如果a比b对应位置的元素都大或相等，则返回true
        for (int i = 0; i < a.length; i++) {
            if (a[i]<b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //输入： increase = [[2,8,4],[2,5,0],[10,9,8]]
        // requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
        //
        //输出: [2,-1,3,-1]
        //通过

/*        int[][] increase = new int[][]{
                {2,8,4},{2,5,0},{10,9,8}
        };
        int[][] requirements = new int[][]{
                {2,11,3},{15,10,7},{9,17,12},{8,1,14}
        };
        int[] out = getTriggerTime(increase, requirements);*/

//        输入： increase = [[0,4,5],[4,8,8],[8,6,1],[10,10,0]]
//        requirements = [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
//
//        输出: [-1,4,3,3,3]
        //通过
        int[][] increase = new int[][]{
                {0,4,5},{4,8,8},{8,6,1},{10,10,0}
        };
        int[][] requirements = new int[][]{
                {12,11,16},{20,2,6},{9,2,6},{10,18,3},{8,14,9}
        };
        int[] out = getTriggerTime(increase, requirements);
        System.out.println(Arrays.toString(out));

/*
        输入： increase = [[1,1,1]] requirements = [[0,0,0]]
        输出: [0]
 */
/*        int[][] increase = new int[][]{
                {1,1,1}
        };
        int[][] requirements = new int[][]{
                {0,0,0}
        };
        int[] out = getTriggerTime(increase, requirements);
        System.out.println(Arrays.toString(out));*/
    }
}