package com.lusr.forwin.YYIWantIt;

import java.util.Scanner;

class Node {
    int val;
    Node next;
}

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node();
        Node tmp = root;
        String str = scanner.nextLine();
        String[] strings = str.split(" ");

        int k = Integer.valueOf(strings[strings.length - 1]);

        for (int i = 0; i < strings.length - 1; i++) {
            Node node = new Node();
            node.val = Integer.valueOf(strings[i]);
            tmp.next = node;
            tmp = tmp.next;
        }

        Node first = root;
        Node seconde = root;
        int count = 0;
        while (root != null) {
//            System.out.println(root.val);
            if (count <= k)
                count++;

            if (count == k +1) {
                first = first.next;
                seconde = seconde.next;
            } else {
                seconde = seconde.next;
            }
            root = root.next;
        }
        System.out.println(first.val);
    }
}
