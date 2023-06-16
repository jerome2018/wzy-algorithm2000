package com.wzy.algorithms.common;

/**
 * FileName: ListNode
 * Description:链表节点定义
 * Author: wangzhenyue
 * Date: 2023/3/30 15:27
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode(){}

    public ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
