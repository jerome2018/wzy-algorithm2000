package com.wzy.algorithms.offer.no00015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: Solution
 * Description: 找出字符串中所有的变位词, 返回所有变位词的在字符串中的起始位置
 * Author: wangzhenyue
 * Date: 2023/7/5 13:18
 */
public class Solution {

    //采用14题的滑动窗口思想解决,本题的差异点仅在判断变位词存在的基础上，记录起始索引而已
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = p.length();
        int m = s.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        if(n <= m){

            for(int i = 0; i < n; i++){
                ++cnt1[p.charAt(i) - 'a'];
                ++cnt2[s.charAt(i) - 'a'];
            }
            if(Arrays.equals(cnt1, cnt2)){
                ans.add(0); //说明p的变位词一定s的前n个字母，起始位置故为0
            }

            for(int j = n; j < m; j++){
                ++cnt2[s.charAt(j) - 'a'];
                --cnt2[s.charAt(j-n) - 'a'];
                if (Arrays.equals(cnt1,cnt2)){
                    ans.add(j-n+1); // 滑动s的窗口，滑动一次比较一次，同时记录起始索引，之所以加1是因为索引0在上面已经记录
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s,p).toString());
    }
}
