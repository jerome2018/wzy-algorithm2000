package com.wzy.algorithms.offer.no00028;

/**
 * FileName: Solution
 * Description: 扁平化多级双向链表
 * Author: wangzhenyue
 * Date: 2023/8/7 16:55
 */
public class Solution {

    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode child;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next, ListNode prev, ListNode child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public ListNode flatten(ListNode head) {
        dfs(head);
        return head;
    }

    //返回链表的最后一个节点
    public ListNode dfs(ListNode node){
        //约定当前头节点，用于后续遍历
        ListNode cur = node;
        ListNode last = null;
        //遍历链表，采用深度优先策略，即最先处理最深的子链表结构
        while(cur != null){
            //存储当前节点的下一个节点
            ListNode next = cur.next;

            //判断节点属性child不为空的场景
            if(cur.child != null){
                //因为需要逐级判断child属性，即深度优先，所以这里需要递归调用
                ListNode childLast = dfs(cur.child); //childLast就是最深的子链表结构的尾节点
                //更新当前所在级的子链表结构中节点的下一个节点
                next = cur.next;

                //连接node与child，实际上扁平化需要做两个重要的步骤，这是第一步
                cur.next = cur.child;//注意cur.child是子链表的头节点
                cur.child.prev = cur; //链接双向链表时，一定要注意需要两条命令，分别明确后继和前驱的指向

                //连接childLst与当前节点的下一个节点next，实际上扁平化需要做两个重要的步骤，这是第二步
                //这里需要判断，如果next为null, 该步骤就可以省略了
                if(next != null){ //连接时，需要注意双向链表节点插入，包含后继节点和前驱节点的指向
                    childLast.next = next;
                    next.prev = childLast;
                }//截止到这里，就完成了子链表到上一级链表的扁平化，即较深链表插入到上一级链表结构中

                //将child属性置为空
                cur.child = null;
                last = childLast;

            }else{
                last = cur;
            }
            //回溯到主链表，此时的next已经更新掉了
            cur = next;
        }
        return last; //返回链表的尾节点

    }



    public static void main(String[] args){
        System.out.println();
    }
}
