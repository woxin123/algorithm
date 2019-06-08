package com.example.leetcode;

import java.util.*;

/**
 * @author mengchen
 * @time 18-11-24 上午11:06
 */
public class LetterCombinations {

    private List<String> result = new ArrayList<>();
    private Map<Integer, String> map;

    /**
     * 递归
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        init();
        digui(new StringBuilder(), digits, 0);
        return result;
    }

    private void init() {
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    private void digui(StringBuilder sb, String dights, int index) {

        int number = Integer.valueOf(String.valueOf(dights.charAt(index)));
        String chars = map.get(number);
        for (int i = 0; i < chars.length(); i++) {
            StringBuilder mmStr = new StringBuilder(sb);
            mmStr.append(chars.charAt(i));
            if (index == dights.length() - 1) {
                result.add(mmStr.toString());
            } else {
                digui(mmStr, dights, index + 1);
            }
        }
    }

    /**
     * 使用队列
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        init();
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.offer(new StringBuilder());

        for (int i = 0; i < digits.length(); i++) {
            int tar = digits.charAt(i) - '0';
            int j = 0, limitSize = queue.size();
            while (!queue.isEmpty() && j < limitSize) {
                StringBuilder sb = queue.poll();
                for (char ch : map.get(tar).toCharArray()) {
                    StringBuilder tmp = new StringBuilder(sb);
                    tmp.append(ch);
                    queue.offer(tmp);
                }
                j++;
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
