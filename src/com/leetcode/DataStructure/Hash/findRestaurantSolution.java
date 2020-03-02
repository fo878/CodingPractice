package com.leetcode.DataStructure.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
* 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
*
* 提示：
*   两个列表的长度范围都在 [1, 1000]内。
*   两个列表中的字符串的长度将在[1，30]的范围内。
*   下标从0开始，到列表的长度减1。
*   两个列表都没有重复的元素。
*
* 分析：
*   在这种方法中，我们枚举 list1中的每一个字符串，遍历整个 list2 一遍，对每一对字符串都进行比较。我们使用哈希表 map，它
*   包含了形如 (sum: list_{sum})的元素。这里 sum 是匹配元素的下标和，list_{sum}是下标和为 sum 的匹配字符串列表。
*   这样，通过比较，一旦 list1中第i个字符串和 list2 中第 j 个字符串匹配，如果 sum 为 i+j 的条目在 map中还没有，我们就加一个条目。
*   如果已经存在，由于我们需要保存所有下标和相同的字符串对，所以我们将这对字符串保存到哈希表中。
*   最后我们遍历 map 的键一遍，并找到下标和最小的字符串列表。
*
* */
public class findRestaurantSolution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();//key是匹配元素的下标和，value是下表和为sum的匹配字符串列表
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])){//过比较，一旦 list1中第i个字符串和 list2 中第 j 个字符串匹配
                    if (!map.containsKey(i+j)){//如果 sum 为 i+j 的条目在 map中还没有，我们就加一个条目。
                        map.put(i+j,new ArrayList<String>());
                    }
                    map.get(i+j).add(list1[i]);//将这对字符串保存到哈希表中
                }
            }
        }
        //遍历 map 的键一遍，并找到下标和最小的字符串列表。
        int min_index_sum = Integer.MAX_VALUE;//赋一个最大值
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        findRestaurantSolution foo = new findRestaurantSolution();
        String[] out = foo.findRestaurant(list1,list2);
        System.out.println(Arrays.toString(out));
    }
}
