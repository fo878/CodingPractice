package com.leetcode.DataStructure.cache.LRU2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* 146. LRU缓存机制
* 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
* 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
* 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
* 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；
* 如果密钥不存在，则插入该组「密钥/数据值」。
* 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

* 在O(1)复杂度完成这两种操作

LRUCache cache = new LRUCache( 2 // 缓存容量  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/lru-cache
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class LRUCache{
    //哈希表 + 双向链表
    /*
    算法
        LRU 缓存机制可以通过哈希表辅以双向链表实现，我们用一个哈希表和一个双向链表维护所有在缓存中的键值对。
        双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
        哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
        这样以来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，
        随后将其移动到双向链表的头部，即可在 O(1)O(1) 的时间内完成 get 或者 put 操作。
        具体的方法如下：
        对于 get 操作:
            首先判断 key 是否存在：
            如果 key 不存在，则返回 -1−1；
            如果 key 存在，则 key 对应的节点是最近被使用的节点。
            通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，
            最后返回该节点的值。
        对于 put 操作:
        首先判断 key 是否存在：
        如果 key 不存在，使用 key 和 value 创建一个新的节点，
        在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
        然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项；
        如果 key 存在，则与 get 操作类似，先通过哈希表定位，
        再将对应的节点的值更新为 value，
        并将该节点移到双向链表的头部。

        上述各项操作中，访问哈希表的时间复杂度为 O(1)，
        在双向链表的头部添加节点、在双向链表的尾部删除节点的复杂度也为 O(1)。
        而将一个节点移到双向链表的头部，可以分成「删除该节点」和「在双向链表的头部添加节点」两步操作，都可以在 O(1)O(1) 时间内完成。
        小贴士
        在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
