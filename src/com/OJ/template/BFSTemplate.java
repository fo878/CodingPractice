package com.OJ.template;

import java.util.*;

public class BFSTemplate {
    int BFS (Node root, Node target){
        Deque<Node> queue = new ArrayDeque<Node>();
        int step = 0;
        //初始化
        queue.add(root);
        while (!queue.isEmpty()){
            step++;
            //遍历已经在队列里边的节点
            for (int i = 0; i < queue.size(); ++i) {
                Node cur = (Node) queue.getFirst();
                if (cur == target){
                    return step;
                }
                //node.next 将Node的所有邻居节点添加到队列中
                queue.addAll(cur.neighbors);
            }
        }
        return -1;//从root到target没有通路
    }
}
