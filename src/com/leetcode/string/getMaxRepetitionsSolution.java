package com.leetcode.string;
/*
466. 统计重复个数
由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。
现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-the-repetitions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class getMaxRepetitionsSolution {
    /*
    * 算法
    * 1.我们设计一个哈希表 recall ：
    *   哈希表 recall 以 s2 字符串的下标 index 为索引，存储匹配至第 s1cnt 个 s1 的末尾，
    *   当前匹配到第 s2cnt 个 s2 中的第 index 个字符时，
    *   已经匹配过的s1 的个数 s1cnt 和 s2 的个数 s2cnt。
    * 2.我们在每次遍历至 s1 的末尾时根据当前匹配到的 s2 中的位置 index 查看哈希表中的对应位置，
    *   如果哈希表中对应的位置 index 已经存储元素，则说明我们找到了循环节。
    *   循环节的长度可以用当前已经匹配的 s1 与 s2 的数量减去上次出现时经过的数量（即哈希表中存储的值）来得到。
    * 3.然后我们就可以通过简单的运算求出所有构成循环节的 s2 的数量，
    *   对于不参与循环节部分的 s1，直接遍历计算即可，具体实现以及一些细节边界的处理请看下文的代码。
    * */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // 特判
        if (len1==0 ||len2==0 || n1==0 || n2==0){
            return 0;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int index = 0;// 记录下一个要匹配的s2中的字符索引
        int count = 0;// 记录匹配完的s2个数
        //记录在遍历每个s1时匹配出的s2的个数,可能包含前面一个s1循环节的部分
        int[] countRecorder = new int[len2+1];
        //记录在每个s1中想要匹配的s2中字符的索引
        int[] indexRecorder = new int[len2+1];

        for (int i = 0; i < n1; i++) {
            //遍历s1
            for (int j = 0; j < len1; ++j) {
                //匹配s2字符，匹配成功，s2索引+1
                if (chars1[j] == chars2[index]){
                    ++index;
                }
                // 匹配完一个s2，计数器+1，重置s2索引
                if (index==chars2.length){
                    index = 0;
                    ++count;
                }
            }
            // 记录遍历完i个s1后s2出现的次数
            countRecorder[i] = count;
            // 记录遍历完第i个s1后s2下一个要被匹配到的字符下标
            indexRecorder[i] = index;
            // 剪枝
            // 查看该索引在之前是否已经出现，出现即表示已经出现循环节，可以直接进行计算
            // 上一次出现该索引是在第j个s1中（同时可以说明第一个循环节的出现是从第j+1个s1开始的）
            for (int j = 0; j < i && indexRecorder[j]==index; ++j) {
                //记录循环节出现之前s2出现的个数
                int preCount = countRecorder[j];
//                记录所有循环节构成的字符串中出现s2的个数
                int patternCount = ((n1-1-j)/(i-j) * (countRecorder[i]-countRecorder[j]));
                //记录剩余未构成完整循环节的部分出现s2的个数
                int remainCount = countRecorder[j + (n1-1-j)%(i-j)] - countRecorder[j];
                //三者相加几位出现s2的总次数
                return (preCount + patternCount +remainCount) /n2;
            }
        }
        // 没有循环节的出现相当于直接使用暴力法
        return countRecorder[n1-1]/n2;
    }

    public static void main(String[] args) {
        String s1 ="acb";
        int n1 = 4;
        String s2 ="ab";
        int n2 = 2;
//        String s1 = "lovelive";
//        int n1 = 0;
//        String s2 = "lovelive";
//        int n2 = 10;
        getMaxRepetitionsSolution foo = new getMaxRepetitionsSolution();
        System.out.println(foo.getMaxRepetitions(s1,n1,s2,n2));
    }
}
