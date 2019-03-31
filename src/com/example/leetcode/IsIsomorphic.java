package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * @author mengchen
 * @time 19-3-31 上午9:21
 */
public class IsIsomorphic {

    /**
     * 使用HashMap
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 利用一个数组来完成
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] map = new int[512];
        for (int i = 0; i < ss.length; i++) {
            if (map[ss[i]] != map[tt[i] + 256]) {
                return false;
            } else {
                map[ss[i]] = i + 1;
                map[tt[i] + 256] = i + 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic2("aa", "ab"));
    }

}
