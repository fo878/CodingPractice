package com.leetcode.DP.stoneGame;
/*
* 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
* 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
* 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
* 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
* 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/stone-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class stoneGameSolution {
    public static boolean stoneGame1(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size < N; ++size) {
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int p = i+j+N;
                if (p%2==1){
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1],dp[i+1][j] + piles[j]);
                }else {
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1],dp[i+1][j] - piles[j]);
                }
            }
        }
        return dp[1][N]>0;
    }
    /*
    亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。
    游戏以谁手中的石子最多来决出胜负。
    亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
    在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
    游戏一直持续到所有石子都被拿走。
    假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/stone-game-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public static int stoneGameII(int[] piles) {
        return 0;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{5,4,3,5};
        System.out.println(stoneGame1(piles));
    }
}
