package com.leetcode.DataStructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 地图分析
你现在手里有一份大小为 N x N 的『地图』（网格） grid，
上面的每个『区域』（单元格）都用 0 和 1 标记好了。
其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？
请返回该海洋区域到离它最近的陆地区域的距离。
我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 
|x0 - x1| + |y0 - y1| 。如果我们的地图上只有陆地或者海洋，请返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class maxDistanceSolution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};//四个方向分别是x+1，x-1,y+1,y-1

        //广度优先搜索需要用到队列,队列中保存的应该是该层的所有坐标
        Queue<int[]> queue = new ArrayDeque<int[]>();
        //先让陆地都入队
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        boolean flagHasOcean = false;
        int[] point = null;
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        while (!queue.isEmpty()){
            point = queue.poll();
            int x= point[0];
            int y= point[1];
            // 取出队列的元素，将其四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                //如果newX、newY超出矩阵范围，或者newX，newY不是未探索过的海洋
                // （探索过的海洋已经置数了，陆地则是1，而未探索过的海洋还是0）
                if (newX<0||newY<0||newX>=m||newY>=n||grid[newX][newY]!=0){
                    continue;
                }
                grid[newX][newY] = grid[x][y]+1;
                flagHasOcean = true;
                queue.offer(new int[]{newX,newY});
            }
        }

        if (!flagHasOcean || point==null){
            //如果没有海洋，或者没有陆地
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,1},{0,0,0},{1,0,1}
        };
        maxDistanceSolution foo = new maxDistanceSolution();
        System.out.println(foo.maxDistance(grid));
    }
}
