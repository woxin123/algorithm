package com.example.leetcode;

import java.util.*;

/**
 * @author mengchen
 * @time 18-10-27 下午5:22
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring3("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean add = list.contains(s.charAt(i));
            list.add(s.charAt(i));
            if (add) {
                if (maxLength < list.size()) {
                    maxLength = list.size() - 1;
                }
                while (!list.get(0).equals(s.charAt(i))) {
                    list.remove(0);
                }
                list.remove(0);
            }
        }
        if (maxLength < list.size()) {
            maxLength = list.size();
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);
            }
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }

}
