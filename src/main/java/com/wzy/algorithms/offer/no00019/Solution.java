package com.wzy.algorithms.offer.no00019;

import java.util.Arrays;

/**
 * FileName: Solution
 * Description: 最多删除一个字符，能否得到一个回文字符串
 * Author: wangzhenyue
 * Date: 2023/7/14 15:47
 */
public class Solution {

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l == r){//左右两边对称相同的字符，继续保留，作为左右双指针收缩的条件
                left++;
                right--;
            }else{
                //假设删除了一个字符，分别从左边或右边，删除后，如果子串是回文串
                return check(s, left, right-1) || check(s, left+1, right);
            }
        }

        return true; //表示原字符串是一个回文串

    }

    public static boolean check(String s, int left, int right){
        //判断子串是否是回文串
        for(int i = left, j = right; i < j; i++, j--){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l != r){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
    }
}
