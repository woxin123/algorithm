package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * @author mengchen
 * @time 19-2-17 下午8:00
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelp(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void partitionHelp(String s, List<List<String>> res, List<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPartition(s, start, i)) {
                list.add(s.substring(start, i + 1));
                partitionHelp(s, res, list, i + 1);
                // 这里的有问题，虽然这么写没错，但是可能会出现答案位置和判题不一样的问题，而且性能不好
                // list.remove(s.substring(start, i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPartition(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++; r--;
        }
        return l >= r;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("cbbbcc"));
    }
}
