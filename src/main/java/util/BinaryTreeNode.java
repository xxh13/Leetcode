package util;

/**
 *
 * Created by XXH on 2016/8/17.
 */
public class BinaryTreeNode implements Comparable{

    public int value;
    public BinaryTreeNode leftNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode rightNode;

    public BinaryTreeNode(int value){
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int compareTo(Object o) {
        return this.getValue() - ((BinaryTreeNode) o).getValue();
    }
}
