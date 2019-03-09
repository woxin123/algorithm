package com.example.leetcode;

import java.util.*;

/**
 * 重复的DNA序列
 * @author mengchen
 * @time 19-3-9 下午3:48
 */
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                res.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }
}
