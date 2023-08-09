package com.wzy.algorithms.offer.no00026;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Description: 重新排列链表
 * Author: wangzhenyue
 * Date: 2023/7/28 11:07
 */
public class Solution {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(){};
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        //边界处理
        if(head == null){
            return;
        }
        //把链表节点取出来放到数组里
        List<ListNode> headList = new ArrayList<ListNode>();
        while(head != null){
            headList.add(head);
            head = head.next;
        }

        //交换节点位置
        int i = 0; //数组的初始指针
        int j = headList.size() - 1; //数组的最大的指针
        while(i < j){ //节点交换的条件，直到i=j时不需要交换，退出循环
            headList.get(i).next = headList.get(j);//把j对应节点移动到i的后面
            i++;//i右移
            if(i == j){//退出循坏
                break;
            }
            headList.get(j).next = headList.get(i);//由于执行了i++, j对应节点的后面变成了i
            j--;//j左移
        }
        headList.get(i).next = null; //循坏执行完毕后，i对应的节点应该是新链表的尾节点

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
