package com.wzy.algorithms.offer.no00017;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * FileName: Solution
 * Description: 找出字符串中包含所有字符的的最小子串
 * Author: wangzhenyue
 * Date: 2023/7/7 16:59
 */
public class Solution {

    static Map<Character, Integer> tmap = new HashMap<>();
    static Map<Character, Integer> smap = new HashMap<>();

    //采用滑动窗口思想，借助哈希表存储要求出现的字符
    //滑动窗口肯定要在较长字符串上进行滑动，即在s字符串上进行滑动
    public  static String minWindow(String s, String t) {
        String ans = "";
        int ns = s.length();
        int nt = t.length();
        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;



        //先枚举字符串t，将其放入哈希表
        for(int i = 0; i < nt; i++){
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }

        //通过窗口滑动开始处理字符串s
        while(right < ns){
            right++;
            if(right < ns && tmap.containsKey(s.charAt(right))){
                smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right),0)+1);
            }

            while(check() && left <= right){//保证s中含有符合条件的字符串后，循环压缩窗口，右移左指针
                if(left - right + 1 < len){//计算窗口长度，len初始化为整数最大值防止溢出，后面循序更新
                    len = right - left +1;
                    ansL = left;
                    ansR = left + len;

                }
                if(tmap.containsKey(s.charAt(left))){//准备右移左指针
                    smap.put(s.charAt(left), smap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }


        }
        ans = ansL == -1? "" : s.substring(ansL, ansR);
        return ans;
    }

    public static boolean check(){
        //遍历字符串t的哈希表
        Iterator iterator = tmap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character  key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if(smap.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
