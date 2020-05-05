package com.wrong.dongfang1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
aabcc dbbca aadbbcbcac,s3是否是由s1,s2组成。
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(" ");
        System.out.println(compose(strings[0],strings[1],strings[2]));
    }

    private static boolean compose(String s1,String s2,String s3){
        int i = 0,j = 0,k=0;
        int n = s3.length();
        int l1 = s1.length();
        int l2 = s2.length();
        if (n!=(l1+l2)) return false;
        while(k<n){
            if (i<l1 & j<l2){
                if (s3.charAt(k)==s1.charAt(i)){
                    k++;
                    i++;
                }else if (s3.charAt(k)==s2.charAt(j)){
                    k++;
                    j++;
                }else {
                    return false;
                }
            }else if (i==l1){
                if (s3.charAt(k)==s2.charAt(j)){
                    j++;
                    k++;
                }else{
                    return false;
                }
            }else if (j==l2){
                if (s3.charAt(k)==s1.charAt(i)){
                    i++;
                    k++;
                }else{
                    return false;
                }
            }
        }
        return k==n;
    }
}
