package com.leetcode.DP;

import java.util.Arrays;

/*
* 1024. 视频拼接
你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/video-stitching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
class videoStitchingSolution {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        int aj,bj;
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j < clips.length; j++) {
                aj = clips[j][0];
                bj = clips[j][1];
                if(i>aj && i<=bj){
                    dp[i] = Math.min(dp[i], dp[aj] + 1) ;
                } 
            }
        }
        return dp[T] == Integer.MAX_VALUE-1 ? -1 : dp[T];
    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{
            {0,2},{4,6},{8,10},{1,9},{1,5},{5,9}
        };
        int T = 10;
        videoStitchingSolution foo = new videoStitchingSolution();
        System.out.println(foo.videoStitching(clips, T));
    }
}
