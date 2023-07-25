package com.wzy.algorithms.offer.no00018;

/**
 * FileName: Solution
 * Description: 判断是否是回文串, 字符串中仅仅考虑字符和数字两种，字符不区分大小写
 * Author: wangzhenyue
 * Date: 2023/7/13 14:25
 */
public class Solution {

    //回文串是指字符串 反转后与原来的字符串相同
    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for(int i = 0; i < n; i++){ //只考虑字符串中字符和数字
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println("sb=====1"+sb.toString());
        StringBuffer sb_rev = new StringBuffer(sb).reverse();//注意需要新建StringBuffer对象，因为StingBuffer是可变的
        System.out.println("sb=====2"+sb.toString());
        System.out.println("sb.reverse====="+sb_rev);
        return sb.toString().equals(sb_rev);
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
