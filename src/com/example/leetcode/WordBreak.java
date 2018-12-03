package com.example.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @auther 孟晨
 * @date 2018/12/3 16:18
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}