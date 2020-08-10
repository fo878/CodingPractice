package com.leetcode.string;
/*
* 415. 字符串相加
*
* 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class addString {
    public static String addStrings(String num1, String num2) {
        int n = num1.length()-1;
        int m = num2.length()-1;
        int add=0;
        StringBuffer out = new StringBuffer();
        while(n>=0 || m>=0 || add!=0){
            int x = n>=0? num1.charAt(n) - '0' : 0;
            int y = m>=0? num1.charAt(m) - '0' : 0;
            int sum = x+y+add;
            out.append(sum%10);
            add = sum/10;
            n--;
            m--;
        }
        out.reverse();
        return out.toString();
    }

    public static String addStrings1(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }


    public static void main(String[] args) {
        String num1 = "12324244121424312122312475757648697";
        String num2 = "1232424412145757648697";
        System.out.println(addStrings1(num1,num2));
    }
}
