package com.leetcode.DataStructure.graph;

import java.util.Arrays;

/*
* 785. 判断二分图
*给定一个无向图graph，当这个图为二分图时返回true。
* 如果我们能将一个图的节点集合分割成两个独立的子集A和B，
* 并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，
* 我们就将这个图称为二分图。
* graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。
* 每个节点都是一个在0到graph.length-1之间的整数。
* 这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-graph-bipartite
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class isBipartiteSolution {
    //算法的流程如下：
    //
    //我们任选一个节点开始，将其染成红色，并从该节点开始对整个无向图进行遍历；
    //
    //在遍历的过程中，如果我们通过节点 u 遍历到了节点 v（即 u 和 v 在图中有一条边直接相连），那么会有两种情况：
    //
    //如果 v 未被染色，那么我们将其染成与 u 不同的颜色，并对 v 直接相连的节点进行遍历；
    //
    //如果 v 被染色，并且颜色与 u 相同，那么说明给定的无向图不是二分图。我们可以直接退出遍历并返回 False 作为答案。
    //
    //当遍历结束时，说明给定的无向图是二分图，返回 True 作为答案。

    //注意：题目中给定的无向图不一定保证连通，因此我们需要进行多次遍历，直到每一个节点都被染色，
    // 或确定答案为 False 为止。每次遍历开始时，我们任选一个未被染色的节点，将所有与该节点直接或间接相连的节点进行染色。


    private static final int unColored = 0;
    private static final int red = 1;
    private static final int green = 2;
    private static boolean valid;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        valid = true;
        Arrays.fill(color,unColored);
        for (int i = 0; i < n && valid; i++) {
            if (color[i] == unColored) {
                dfs(i, red, graph);
            }
        }
        return valid;
    }

    private void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c==red? green : red;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == unColored){
                dfs(neighbor,cNei,graph);
                if (!valid){
                    return;
                }
            }
            else if (color[neighbor] != cNei){
                valid = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        isBipartiteSolution foo = new isBipartiteSolution();
        System.out.println(foo.isBipartite(graph));
    }
}
