package com.example.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mengchen
 * @time 18-12-1 下午3:38
 */
public class CheckInclusion {

    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[] c1 = new int[26];
        Arrays.fill(c1, 0);
        int[] c2 = new int[26];
        Arrays.fill(c2, 0);
        for (char ch : s1.toCharArray()) {
            c1[ch - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            if (i >= n1) {
                --c2[s2.charAt(i - n1) - 'a'];
            }
            c2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;
    }


}
