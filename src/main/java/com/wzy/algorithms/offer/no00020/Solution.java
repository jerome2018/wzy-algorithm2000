package com.wzy.algorithms.offer.no00020;

/**
 * FileName: Solution
 * Description: 输出字符串中回文串的个数
 * Author: wangzhenyue
 * Date: 2023/7/19 9:16
 */
public class Solution {

    //采用回文中心扩展
    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int l = 0;
        int r = 0;

        for(int i = 0; i < 2*n-1; i++){ //有序遍历回文中心，奇数和偶数回文中心合并遍历
            l = i / 2;
            r = i / 2 + i % 2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){//是回文子串的条件，以此回文中心为中心向两边扩展
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
