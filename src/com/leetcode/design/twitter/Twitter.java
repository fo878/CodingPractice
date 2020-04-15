package com.leetcode.design.twitter;

import java.util.*;

/*
* 计一个简化版的推特(Twitter)
* 可以让用户实现发送推文，
* 关注/取消关注其他用户，
* 能够看见关注人（包括自己）的最近十条推文。
* 你的设计需要支持以下的几个功能：
    postTweet(userId, tweetId): 创建一条新的推文
    getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
                        推文必须按照时间顺序由最近的开始排序。
    follow(followerId, followeeId): 关注一个用户
    unfollow(followerId, followeeId): 取消关注一个用户

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-twitter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */


class Twitter {

    /**
     * 用户 id 和推文（单链表）的对应关系
     */
    private Map<Integer,Tweet> twitter;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;


    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     */
    private static PriorityQueue<Tweet> maxHeap;

    /** Initialize your data structure here. */
    public Twitter() {
        twitter = new HashMap<Integer,Tweet>();
        followings = new HashMap<Integer, Set<Integer>>();
        maxHeap = new PriorityQueue<Tweet>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }
    
    /** Compose a new tweet.发送一条新推文 */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId,timestamp);
            newHead.next = oldHead;
            twitter.put(userId,newHead);
        }else {
            twitter.put(userId,new Tweet(tweetId,timestamp));
        }
    }
    
    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * */
    public List<Integer> getNewsFeed(int userId) {
        //全局使用，使用前需要清空
        maxHeap.clear();

        //自己发的推文
        if (twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        //获得关注人的列表
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size()>0){
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet!=null){
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while(!maxHeap.isEmpty() && count<10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if (head.next!=null){
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }
    
    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * @param followeeId 被关注者id
     * @param followerId 发起关注者id
     * */
    public void follow(int followerId, int followeeId) {
        if (followeeId==followerId) return;//不能关注自己
        //获取自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList==null){
            Set<Integer> init = new HashSet();
            init.add(followeeId);
            followings.put(followerId,init);
        }else {
            if (followingList.contains(followeeId)){
                return;
            }else {
                followingList.add(followeeId);
            }
        }
    }
    
    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * @param followerId 发起取消关注的人
     * @param followeeId 被取消关注的人
     * */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId==followerId) return;//不能取消关注自己
        //获取自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList==null) return;
        followingList.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */