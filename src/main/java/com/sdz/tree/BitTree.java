package com.sdz.tree;

import java.util.*;

public class BitTree {
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private Integer value;

        private TreeNode(TreeNode left, TreeNode right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;


        }
    }

    private TreeNode createTree(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(null, null, list.get(0));
        queue.add(root);
        int i = 1;
        while (i < list.size()) {
            TreeNode parent = queue.poll();
            parent.left = new TreeNode(null, null, list.get(i));
            queue.add(parent.left);
            i++;
            if (i < list.size()) {
                parent.right = new TreeNode(null, null, list.get(i));
                queue.add(parent.right);
                i++;
            }
        }

        return root;

    }

    private List<List<Integer>> findPath(TreeNode root, Integer target) {
        //保存所有符合条件的路径
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        //当前路径
        List<Integer> list = new ArrayList<Integer>();
        return findPath(listAll, list, root, target);
    }

    private List<List<Integer>> findPath(List<List<Integer>> listAll, List<Integer> list, TreeNode root, Integer target) {
        if (root == null) return listAll;
        list.add(root.value);
        target -= root.value;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        findPath(listAll, list, root.left, target);
        findPath(listAll, list, root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    public void printSolution(Integer target, List list) {
        List<List<Integer>> result = findPath(createTree(list), target);
        if (result == null || result.size() == 0) {
            return;
        }
        for (List<Integer> eachList : result) {
            for (Integer integer : eachList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BitTree bitTree = new BitTree();
        bitTree.printSolution(22, Arrays.asList(10, 5, 12, 4, 7));
    }
}
