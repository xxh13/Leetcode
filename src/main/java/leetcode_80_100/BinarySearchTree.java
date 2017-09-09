package leetcode_80_100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * Created by XXH on 2017/9/7.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree demo = new BinarySearchTree();
        demo.generateTrees(0).forEach(BinarySearchTree::inorderTraversal);
    }

    private static void inorderTraversal(TreeNode root) {
        if ( root !=  null) {
            inorderTraversal(root.left);
            System.out.println(root.val);
            inorderTraversal(root.right);
        }
    }

    public int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < array.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j ==i) {
                    array[i] += array[i - 1];
                } else {
                    array[i] += array[j - 1] * array[i - j];
                }
            }
        }
        IntStream.of(array).forEach(System.out::println);
        return array[n];
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>() ;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        TreeNode node = new TreeNode(1);
        List<TreeNode> fir_list = new LinkedList<>();
        fir_list.add(node);
        map.put(1, fir_list);
        for (int i = 2; i <= n; i++) {
            List<TreeNode> list = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    List<TreeNode> preList = map.get(i - 1);
                    for (TreeNode tn: preList){
                        TreeNode temp = new TreeNode(j);
                        if (j == 1) {
                            temp.right = increase(tn, j);
                        } else {
                            temp.left = tn;
                        }
                        list.add(temp);
                    }
                } else {
                    List<TreeNode> leftList = map.get(j - 1);
                    List<TreeNode> rightList = map.get(i - j);
                    for (TreeNode nodeLeft : leftList){
                        for (TreeNode nodeRight : rightList) {
                            TreeNode temp = new TreeNode(j);
                            temp.left = nodeLeft;
                            temp.right = increase(nodeRight, j);
                            list.add(temp);
                        }
                    }
                }
            }
            map.put(i, list);
        }

        return map.get(n);
    }

    private TreeNode increase(TreeNode root, int value) {
        if (root != null) {
            TreeNode node = new TreeNode(root.val);
            node.val += value;
            node.left = increase(root.left, value);
            node.right = increase(root.right, value);
            return node;
        }
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
