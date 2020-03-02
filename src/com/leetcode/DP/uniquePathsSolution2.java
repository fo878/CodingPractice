package com.leetcode.DP;

/*
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
* 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
* 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
* 示例：
*   输入:
*   [
*      [0,0,0],
*      [0,1,0],
*      [0,0,0]
*   ]
*   输出: 2

  分析：
    1.如果第一个格点 obstacleGrid[0,0] 是 1，说明有障碍物，那么机器人不能做任何移动，我们返回结果 0。
    2.否则，如果 obstacleGrid[0,0] 是 0，我们初始化这个值为 1 然后继续算法。
    3.遍历第一行，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i,j-1]。
    4.遍历第一列，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i-1,j]。
    5.现在，从 obstacleGrid[1,1] 开始遍历整个数组，如果某个格点初始不包含任何障碍物，就把值赋为上方和左侧两个格点方案数之和 obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]。
    6.如果这个点有障碍物，设值为 0 ，这可以保证不会对后面的路径产生贡献。
* */
class uniquePathsSolution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //1.如果第一个格点 obstacleGrid[0,0] 是 1，说明有障碍物，那么机器人不能做任何移动，我们返回结果 0。
        if (obstacleGrid[0][0] == 1){
            return 0;
        }else if (obstacleGrid[0][0] == 0){//2.否则，如果 obstacleGrid[0,0] 是 0，我们初始化这个值为 1 然后继续算法。
            obstacleGrid[0][0] = 1;
        }
        //3.遍历第一行，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1){
                obstacleGrid[0][j] = 0;
            }else {//否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i,j-1]。
                obstacleGrid[0][j] = obstacleGrid[0][j-1];
            }
        }

        //4.遍历第一列，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                obstacleGrid[i][0] = 0;
            }else {//否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i-1,j]。
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }
        //5.现在，从 obstacleGrid[1,1] 开始遍历整个数组，如果某个格点初始不包含任何障碍物，就把值赋为上方和左侧两个格点方案数之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }else {//如果这个点有障碍物，设值为 0 ，这可以保证不会对后面的路径产生贡献
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        uniquePathsSolution2 s = new uniquePathsSolution2();
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}
