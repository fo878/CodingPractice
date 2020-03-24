package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String line1 = line.substring(1,line.length()-1);
        String[] strings = line1.split(",");
        int[] cards = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cards[i] = Integer.parseInt(strings[i]);
            //若牌为三位，取后两位
            if (cards[i]>99){
                cards[i] -= (cards[i] / 100)*100;
            }
        }
        Solution foo = new Solution();
        System.out.println(foo.check5Link(cards));
    }

    /**
     * 检查5张牌是否顺子
     * @param cards int整型一维数组 5张随机牌
     * @return bool布尔型
     */
    public boolean check5Link(int[] cards) {
        // write code here
        int minValue = 13;//扑克牌最大的是K
        int maxValue = cards[0];
        HashSet set = new HashSet();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == 0) continue;
            if (cards[i]<minValue){
                minValue = cards[i];
            }
            if (cards[i]>maxValue){
                maxValue = cards[i];
            }
            if (!set.add(cards[i])){
                return false;
            }
        }
        return maxValue - minValue + 1 <= 5;
    }
}