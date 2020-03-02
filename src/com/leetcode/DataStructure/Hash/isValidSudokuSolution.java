package com.leetcode.DataStructure.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
* 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

* */
public class isValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        //希望遍历二维矩阵，将矩阵内的元素保存到row行集合、col列集合、box集合中


        return true;
    }

    public boolean isValudSubSudoku(char[] M){
        //拆分成9个的子数组，看看是否满足数独的要求
        HashSet<Character> set = new HashSet<>();
        for (char c : M) {
            if (c!='.' && !set.contains(c)){
                set.add(c);
            }else if (c!='.'){
                return false;
            }
        }
        return true;
    }

    /*官方答案*/
    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isValidSudokuSolution foo = new isValidSudokuSolution();
        char[] M ={'1','2','.','4','.','5','6','7','8'};
        System.out.println(foo.isValudSubSudoku(M));
    }
}
