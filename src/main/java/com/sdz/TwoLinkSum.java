package com.sdz;

import java.util.Random;

/**
 * @author : songdezhi
 * @date : 2019/9/10
 */
public class TwoLinkSum {
    static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static void forEach(Node head) {
        System.out.println("link begin");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
        System.out.println("link end");

    }

    private static Node initLinkList(int length) {
        Random random = new Random();
        Node head = new Node(random.nextInt(10), null);
        Node p = head;
        for (int i = 0; i < length - 1; i++) {
            p.next = new Node(random.nextInt(10), null);
            p = p.next;
        }
        return head;
    }

    private static Node add(Node node1, Node node2) {
        Node head = new Node(0, null);
        Node p = node1, q = node2, current = head;
        Integer remainder = 0, trade = 0, sum = 0;
        while (p != null || q != null) {
            Integer pvalue = p == null ? 0 : p.value;
            Integer qvalue = q == null ? 0 : q.value;
            sum = pvalue + qvalue + trade;
            trade = sum / 10;
            remainder = sum % 10;
            current.next = new Node(remainder, null);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (trade != 0) {
            current.next = new Node(trade, null);
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node node1 = initLinkList(3);
        Node node2 = initLinkList(5);
        forEach(node1);
        forEach(node2);
        forEach(add(node1, node2));
    }


}
