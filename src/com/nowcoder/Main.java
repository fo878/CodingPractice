package com.nowcoder;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int boss_num = sc.nextInt();
        //与其用数组去维护boss的坐标位置，不如直接在表里填-1，表示不可走
        long[][] mv = new long[x+1][y+1];//因为从0开始到y，所以空间是y+1;
        for(int i=0;i<boss_num;i++) {
            mv[sc.nextInt()][sc.nextInt()]=-1;
        }
        long res = count_mv(x,y,mv);
        System.out.println(res);
    }
    // 思路：维系一个动态规划表，表格下标代表位置
    //当自己的位置在（i，j)时候，走法一共有 mv[i][j]=mv[i][j-1]+mv[i-1][j]
    //因为都表示只差一步就到（i,j)，所以情况相加就行
    //考虑到对称性，决定只填上三角形，"但这是不对"！,只填上三角形存在一种情况，上一行那个数是老板位置为0,你无法*2
    //会漏掉前一列可以行走的可能性！
    //因此需要初始化第一行来符合上面的公式，
    private static long count_mv(int x, int y,long[][] mv) {
        //初始化
        for(int i=0;i<=y;i++) {
            mv[0][i]=1;//在同一行的时候，只有1种情况，右移
        }
        for(int i=0;i<=x;i++) {
            mv[i][0]=1;//同一列只有一种情况
        }
        //填表，按行、上三角形填
        for(int i=1;i<=x;i++) {
            for(int j=1;j<=y;j++) {
                if(mv[i][j] == -1) mv[i][j]=0; //老板位置不走,走法为0
                else    mv[i][j]=mv[i][j-1]+mv[i-1][j];
            }
        }
        return mv[x][y];
    }
}