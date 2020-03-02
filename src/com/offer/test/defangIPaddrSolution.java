package com.offer.test;
/*
给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。

示例：
    输入：address = "1.1.1.1"
    输出："1[.]1[.]1[.]1"

* */
public class defangIPaddrSolution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        defangIPaddrSolution foo = new defangIPaddrSolution();
        System.out.println(foo.defangIPaddr(address));
    }
}
