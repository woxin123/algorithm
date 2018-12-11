package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-10 上午8:08
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> lists = new ArrayList<>();
        restoreIpAddresses("", s, lists, 0);
        return lists;
    }

    public void restoreIpAddresses(String s, String t, List<String> lists, int k) {
        if (k == 3) {
            if (isValid(t)) {
                lists.add(s + t);
            }
        }
        if (k >= 4) {
            return;
        }
        for (int i = 0; i < 4 && i < t.length(); i++) {
            String curr = t.substring(0, i + 1);
            if (isValid(curr)) {
                restoreIpAddresses(s + curr + '.', t.substring(i + 1), lists,k + 1);
            }
        }
    }
    boolean isValid(String s) {
        int temp;
        try {
            temp = Integer.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        if (temp >= 0 && temp <= 255) {
            if (s.length() == 1) {
                return true;
            }
            if (s.length() > 1 && s.charAt(0) != '0') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("010010");
        System.out.println(strings);
    }
}
