package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author mengchen
 * @time 19-4-29 下午2:15
 */
public class WordDictionary {
    private class TrieNode {
        public int begin;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            begin = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null) return;
        TrieNode node = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (node.nexts[index] == null)
                node.nexts[index] = new TrieNode();
            node = node.nexts[index];
            node.begin++;
        }
        node.end++;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null) return false;
        return searchHelper(word.toCharArray(), root, 0);
    }

    private boolean searchHelper(char[] word, TrieNode root, int k) {
        if (k == word.length)
            return root.end > 0;
        boolean exist = false;
        if (word[k] == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.nexts[i] == null) continue;
                exist |= searchHelper(word, root.nexts[i], k + 1);
            }
        } else {
            int i = word[k] - 'a';
            if (root.nexts[i] == null)
                return false;
            exist = searchHelper(word, root.nexts[i], k + 1);
        }
        return exist;
    }
}