package com.wzy.algorithms.offer.no00025;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FileName: Solution
 * Description: 两个链表中数相加，输出相加后的新链表
 * Author: wangzhenyue
 * Date: 2023/7/27 15:16
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //使用栈来解决，先把链表压入对应的栈中，再依次弹出相加，注意逢10的进位
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        //分别压入栈1和栈2
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        //依次从栈中弹出相加
        int carry = 0; //定义一个进位
        ListNode ans = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){//这里的三个条件是或的关系，只要有一个成立，就意味着cur会有值，即会成为新链表的节点
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur/10;
            //创建当前节点
            ListNode curNode = new ListNode(cur%10);
            //连接节点，指向指针
            curNode.next = ans;
            //移动ans,循环完毕后，指向新链表的头节点
            ans = curNode;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
