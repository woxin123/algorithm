package com.example.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author mengchen
 * @time 19-2-3 下午10:01
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(n - 1) != '0') {
            dp[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                if (i == n - 2) {
                    dp[i] = dp[i + 1] + 1;
                } else {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("230"));
    }
}
