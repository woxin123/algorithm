package com.example.剑指offer;

import java.util.ArrayList;

public class FindPath {

    private ArrayList<ArrayList<Integer>> filePaths = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return filePaths;
        }
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            filePaths.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return filePaths;
    }
}
