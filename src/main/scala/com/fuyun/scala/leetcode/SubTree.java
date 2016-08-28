package com.fuyun.scala.leetcode;

/**
 * Created by bl05959 on 2016/8/25.
 * 判断一个树是否为另一个树的左子树
 */
public class SubTree {
    public static class Node {
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        int value;
        Node left;
        Node right;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3, new Node(25, null, new Node(352)), new Node(26));
        Node node2 = new Node(3, new Node(342, new Node(32), new Node(352, null, node1)), new Node(26));
        SubTree subTree = new SubTree();
        System.out.println(subTree.treeToStr(node1));
        System.out.println(subTree.treeToStr(node2));
        System.out.println(subTree.isSubTree(node1, node2));
        System.out.println(subTree.isSubTree(node2, node1));
    }

    public boolean isSubTree(Node a, Node b) {
        return treeToStr(a).contains(treeToStr(b));
    }

    private String treeToStr(Node root) {
        return root == null ? "-;" : (root.value + ";" + treeToStr(root.left) + treeToStr(root.right));
    }
}
