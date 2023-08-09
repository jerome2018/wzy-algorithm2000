package com.wzy.algorithms.offer.no00023;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Description: 找出两个单链表的相交节点，没有相交返回null
 * Author: wangzhenyue
 * Date: 2023/7/25 14:33
 */
public class Solution {


    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    //采用哈希表解决，先对A链表写入哈希表，然后遍历B链表，判断哈希表是否包含某节点，若包含，则为相交节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aSet = new HashSet<>();
        while(headA != null ){
            if(!aSet.contains(headA)){
                aSet.add(headA);
            }
            headA = headA.next;
        }

        while (headB != null){
            if(aSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //采用双指针
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){ //当pA和pB相等的时候，所遍历的节点刚好是相交节点
            pA = pA == null ? headB : pA.next; //A链表中，pA开始指向headA , 遍历完A链表后，指向链表B的头节点继续遍历
            pB = pB == null ? headA : pB.next; //B链表同样，pB先遍历完链表B，然后指向A链表的头节点headA继续遍历
        }
        return pB;
    }

    public static void main(String[] args) {

        //定义链表A
        ListNode headA = new ListNode(0);
        ListNode nodeA1 = new ListNode(9);
        ListNode nodeA2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        headA.next = nodeA1;
        nodeA1.next = nodeA2;
        nodeA2.next = node3;
        node3.next = node4;
        node4.next = null;

        //定义链表B
        ListNode headB = new ListNode(3);
        headB.next = node3;

        ListNode ans = getIntersectionNode1(headA, headB);
        System.out.println(ans.val);
    }
}
