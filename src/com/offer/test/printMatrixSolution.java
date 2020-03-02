package com.offer.test;

/*
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下4 X 4矩阵：
*   1   2   3   4
*   5   6   7   8
*   9   10  11  12
*   13  14  15  16 则
* 依次打印出数字
*   1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*
* 分析：
*   求出行数m与列数n，统计矩阵元素个数m*n;
*   空矩阵，返回null;
*   单元素矩阵，直接将元素添加到list中，返回结果
*   每步输出结果添加到list中;
*   顺时针打印矩阵分为右、下、左、上四个方向;行号i，列号j
*       右操作：行号不变，列号加1
*       下操作：列号不变，行号加1
*       左操作：行号不变，列号减1
*       上操作：列号不变，行号减1
*
*   递归：
*       右、下、左、上四种操作：
*       右操作，列号大于n-r时转为下操作
*       下操作，当行号大于m-r时转为左操作
*       左操作，当列号小于0+r时转为上操作
*       上操作，当行号小于0+r时转为右操作，记录圈数r++
*       当list.size()==m*n时返回list
*
*
*
* */
import java.util.ArrayList;
class printMatrixSolution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();//用来保存打印出的数字
        int m,n;
        m = matrix.length;//行数
        n = matrix[0].length;//列数
        int mn = m*n;//总元素数
        if(matrix==null || mn==0) { return result ; }
        //按顺时针遍历矩阵
        printElement(matrix,0,0,m-1,n-1,result);
        return result;
    }

    //该方法用于求解下一个要打印的元素
    //参数分别是二维矩阵matrix，开始行，开始列，结束行，结束列，返回结果
    public void printElement(int[][] matrix,int startRow,int startCol, int endRow, int endCol,ArrayList<Integer> result){
        if (startRow < endRow && startCol<endCol){
            //right
            for (int j = startCol; j < endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            //down
            for (int i = startRow; i < endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            //left
            for (int j = endCol; j > startCol ; j--) {
                result.add(matrix[endRow][j]);
            }
            //up
            for (int i = endRow; i > startRow; i--) {
                result.add(matrix[i][startCol]);
            }
            printElement(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printMatrixSolution f = new printMatrixSolution();
        ArrayList<Integer> arrayList = f.printMatrix(matrix);
        System.out.println(arrayList.toString());
    }
}