package datastructure;

public class MyBinarySearchTree<E extends Comparable<E>> {

    public static void test() {

    }

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);

        binarySearchTree.remove(5);
        binarySearchTree.remove(3);

        System.out.println();
    }

    private TreeNode<E> root;

    public MyBinarySearchTree() {
        System.out.println();
    }

    /**
     * search the element
     * @param e :
     * @return boolean
     */
    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.val) < 0) {
                current = current.leftNode;
            } else if (e.compareTo(current.val) > 0) {
                current = current.rightNode;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * insert into binary search tree, unique element required
     * @param e:
     * @return boolean
     */
    public boolean insert(E e) {
        TreeNode<E> current = root, parent = null;
        if (current == null) {
            root = new TreeNode<>(e);
            return true;
        }
        while (current != null) {
            if (e.compareTo(current.val) < 0) {
                parent = current;
                current = current.leftNode;
            } else if (e.compareTo(current.val) > 0) {
                parent = current;
                current = current.rightNode;
            } else {
                return false;
            }
        }
        if (e.compareTo(parent.val) < 0) {
            parent.leftNode = new TreeNode<>(e);
        } else {
            parent.rightNode = new TreeNode<>(e);
        }

        return true;
    }

    /**
     * remove element from tree
     * @param e:
     * @return :
     */
    public boolean remove(E e) {
        TreeNode<E> current = root, parent = null;

        while (current != null) {
            if (e.compareTo(current.val) < 0) {
                parent = current;
                current = current.leftNode;
            } else if (e.compareTo(current.val) > 0) {
                parent = current;
                current = current.rightNode;
            } else {
                //if parent is null, the the node is current
                if (parent == null) {
                    parent = root;
                }
                //if the node is leaf node
                if (current.leftNode == null && current.rightNode == null) {
                    if (parent.val.compareTo(current.val) < 0) {
                        parent.rightNode = null;
                    } else {
                        parent.leftNode = null;
                    }
                }
                else if (current.rightNode == null && current.leftNode != null) {
                    if (parent.val.compareTo(current.val) < 0) {
                        parent.rightNode = current.leftNode;
                    } else {
                        parent.leftNode = current.leftNode;
                    }
                } else if (current.leftNode == null && current.rightNode != null) {
                    if (parent.val.compareTo(current.val) < 0) {
                        parent.rightNode = current.rightNode;
                    } else {
                        parent.leftNode = current.rightNode;
                    }
                } else {
                    //两个儿子节点都不为空，选择左子树的最大值或者右子树的最小值替换删除的元素, 我们选择左子树的最大值
                    TreeNode<E> rightParent = current;
                    TreeNode<E> rightNode = rightParent.leftNode;
                    while (rightNode.rightNode != null) {
                        rightParent = rightNode;
                        rightNode = rightParent.rightNode;
                    }
                    current.val = rightNode.val;
                    //将最子树最大值的父亲节点的右边节点只想右子树的左节点
                    rightParent.rightNode = rightNode.leftNode;
                }
                break;
            }
        }

        return false;
    }

    static class TreeNode<E> {
        TreeNode<E> leftNode;
        TreeNode<E> rightNode;

        E val;

        TreeNode(E val) {
            this.val = val;
        }
    }
}
