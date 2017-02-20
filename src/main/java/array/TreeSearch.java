package array;

import util.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Created by XXH on 2016/8/17.
 */
public class TreeSearch {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);

        node1.leftNode = node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;
        node4.rightNode = node8;
        node8.rightNode = node9;

        treeSearch(node1);
        System.out.println();
        treeSearch2(node1);
    }


    public static void treeSearch(BinaryTreeNode root) {
        BinaryTreeNode node, popNode;
        List<BinaryTreeNode> trace = new LinkedList<>();
        Stack<BinaryTreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            node = s.peek();

            if (!trace.contains(node.leftNode) && node.leftNode != null) {
                s.push(node.leftNode);
            }else {
                popNode = s.pop();
                trace.add(popNode);
                System.out.print(popNode.value + " ");

                if (node.rightNode != null) {
                    s.push(node.rightNode);
                }
            }

        }
    }

    public static void treeSearch2(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.leftNode;
            }else {
                node = s.pop();
                System.out.print(node.value + " ");
                node = node.rightNode;
            }
        }
    }

}
