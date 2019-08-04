package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 18-10-28 下午12:37
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> strs = new ArrayList<>();
        backtrack(strs, "", 0, 0, n);
        return strs;
    }

    private void backtrack(List<String> strs, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            strs.add(cur);
            return;
        }
        if (open < max) {
            backtrack(strs, cur + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(strs, cur + ")", open, close + 1, max);
        }
    }
}
