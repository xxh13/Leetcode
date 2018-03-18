package datastructure;

public class NodeList {

    static class Node {
        int x;
        Node(int x) {
            this.x = x;
        }
        Node next;
    }

    static Node reverseList(Node head) {
        Node nodePre = null;
        Node current = head;
        Node resultNode = null;
        Node nodeNext = null;

        while (current != null) {
            nodeNext = current.next;

            if (nodeNext == null) {
                resultNode = current;
            }

            current.next = nodePre;
            nodePre = current;
            current = nodeNext;
        }

        return resultNode;
    }

    static void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.x);
            cur = cur.next;
        }
    }

    public static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printList(reverseList(node1));
    }

    public static void main(String[] args) {
        test();
    }
}
