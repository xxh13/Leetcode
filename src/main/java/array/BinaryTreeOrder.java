package array;

import java.util.*;

/**
 *
 * Created by XXH on 2016/8/20.
 */
public class BinaryTreeOrder {

    // 队列实现
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        List<TreeNode> nodeList = new LinkedList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode tempNode;

        if (root == null) return lists;
        queue.add(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                tempNode = queue.poll();
                list.add(tempNode.val);
                nodeList.add(tempNode);
            }
            lists.add(new LinkedList<>(list));
            for (TreeNode tn : nodeList) {
                if (tn.left != null) queue.add(tn.left);
                if (tn.right != null) queue.add(tn.right);
            }
            list.clear();
            nodeList.clear();
        }

        for (int i = 1; i < lists.size(); i+=2) {
            Collections.reverse(lists.get(i));
        }
        return lists;
    }

    // 递归实现
    private void travel1(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel1(curr.left, sol, level + 1);
        travel1(curr.right, sol, level + 1);
    }

    static public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
}
