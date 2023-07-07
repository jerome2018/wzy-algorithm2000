package com.wzy.algorithms.offer.no00016;

import java.util.HashMap;
import java.util.HashSet;

/**
 * FileName: Solution
 * Description: 找出最长连续子字符串的长度
 * Author: wangzhenyue
 * Date: 2023/7/5 14:16
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int r = 0;
        //定义哈希表，帮助去重
        HashSet<Character> hs = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(i != 0){
                hs.remove(s.charAt(i-1)); //左指针 右移，将左边字符移除集合
            }
            while(r < n && !hs.contains(s.charAt(r))){//在不重复和长度范围的条件下
                hs.add(s.charAt(r));
                r++;//右指针 右移
            }
            ans = Math.max(ans,r-i);//统计的最长子串长度
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
