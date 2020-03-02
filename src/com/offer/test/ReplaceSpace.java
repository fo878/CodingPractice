package com.offer.test;

/*
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* */
public class ReplaceSpace {
    public StringBuffer replaceSpace(StringBuffer str) {
        StringBuffer str1 = new StringBuffer();
        if (str == null){
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                str1.append('%').append('2').append('0');
            }else {
                str1.append(str.charAt(i));
            }
        }
        return str1;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        StringBuffer s = new ReplaceSpace().replaceSpace(str);
        System.out.println(s);
    }
}
