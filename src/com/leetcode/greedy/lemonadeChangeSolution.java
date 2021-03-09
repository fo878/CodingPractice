package com.leetcode.greedy;
//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
// 注意，一开始你手头没有任何零钱。
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
// 示例 1：
//
// 输入：[5,5,5,10,20]
//输出：true
// 示例 2：
//
// 输入：[5,5,10]
//输出：true
// 示例 3：
// 输入：[10,10]
//输出：false
// 示例 4：
// 输入：[5,5,10,10,20]
//输出：false
// 提示：
// 0 <= bills.length <= 10000
// bills[i] 不是 5 就是 10 或是 20 
// 
// Related Topics 贪心算法 

import java.util.HashMap;

class lemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        HashMap<Integer,Integer> changeMap = new HashMap<Integer,Integer>();
        changeMap.put(5,0);
        changeMap.put(10,0);
        changeMap.put(20,0);
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                changeMap.put(5,changeMap.get(5) + 1);
            } else if (bills[i] == 10) {
                if (changeMap.get(5) <= 0) {
                    return false;
                } else {
                    changeMap.put(10,changeMap.get(10) + 1);
                    changeMap.put(5,changeMap.get(5)-1);
                }
            } else if (bills[i] == 20) {
                if (changeMap.get(5) <= 0) {
                    return false;
                }
                if (changeMap.get(10) > 0) {
                    changeMap.put(20,changeMap.get(20) + 1);
                    changeMap.put(10,changeMap.get(10) - 1);
                    changeMap.put(5,changeMap.get(5) - 1);
                } else if (changeMap.get(5)<3) {
                    return false;
                } else {
                    changeMap.put(20,changeMap.get(20) + 1);
                    changeMap.put(5,changeMap.get(5) - 3);
                }
            }
        }
        return true;
    }
}

