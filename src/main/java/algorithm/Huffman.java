package algorithm;

import util.BinaryTreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 创造一颗huffman树，并对其字符进行编码
 * Created by XXH on 2017/1/6.
 */
public class Huffman {

    public static void main(String[] args) {
        List<HuffmanNode> list = new LinkedList<>();
        list.add(new HuffmanNode(10, "a", null, null));
        list.add(new HuffmanNode(15, "e", null, null));
        list.add(new HuffmanNode(12, "i", null, null));
        list.add(new HuffmanNode(3, "s", null, null));
        list.add(new HuffmanNode(4, "t", null, null));
        list.add(new HuffmanNode(13, "sp", null, null));
        list.add(new HuffmanNode(1, "newline", null, null));

        HuffmanNode rootNode = createHuffmanTrie(list);
        StringBuilder sb = new StringBuilder("");
        getHuffmanCode(rootNode, "e", sb);
        System.out.println(sb.toString());
        System.out.println(rootNode.right.left.code);

    }

    public static HuffmanNode createHuffmanTrie(List<HuffmanNode> huffmanCode) {
        List<HuffmanNode> list = huffmanCode;

        Collections.sort(list);
        int count = huffmanCode.size();
        for (int i = count; i > 1; i--) {
            HuffmanNode left = list.remove(0);
            HuffmanNode right = list.remove(0);
            HuffmanNode newNode = new HuffmanNode(left.weight + right.weight, "", left, right);
            list.add(getIndex(newNode, list), newNode);
        }

        return list.get(0);
    }

    private static int getIndex(HuffmanNode node, List<HuffmanNode> list) {
        int i = 0;
        for (; i <list.size(); i++) {
            if (node.weight <= list.get(i).weight) break;
        }

        return i;
    }

    public static boolean getHuffmanCode(HuffmanNode node, String code, StringBuilder sb) {
        if (node == null) return false;

        if (node.code.equals(code)) return true;

        boolean isFound;

        isFound = getHuffmanCode(node.getLeft(), code, sb.append("0"));
        if (isFound) {
            return true;
        }else {
            sb.deleteCharAt(sb.length() - 1);
        }
        isFound = getHuffmanCode(node.getRight(), code, sb.append("1"));
        if (isFound) {
            return true;
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;

    }

    //sort map by value
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> (e1),
                        LinkedHashMap::new
                        ));
    }

    static class HuffmanNode implements Comparable{
        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public HuffmanNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanNode left) {
            this.left = left;
        }

        public HuffmanNode getRight() {
            return right;
        }

        public void setRight(HuffmanNode right) {
            this.right = right;
        }

        private int weight;
        private String code;
        private HuffmanNode left;
        private HuffmanNode right;

        public HuffmanNode(String code) { this.code = code;}

        public HuffmanNode(int weight, String code, HuffmanNode left, HuffmanNode right) {
            this.weight = weight;
            this.code = code;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Object o) {
            return this.weight - ((HuffmanNode) o).weight;
        }

    }
}
