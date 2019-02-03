package com.example.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author mengchen
 * @time 19-2-3 下午10:01
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 1) {
            return s == "0" ? 0 : 1;
        }

        if (s.startsWith("0")) {
            return 0;
        }

        if (s.contains("00")) {
            return 0;
        }


        int[] dp = new int[n];
        if (s.charAt(n - 1) != '0') {
            dp[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                dp[i] = dp[i + 1] + 1;
                if (s.charAt(i + 1) == '0') {
                    i--;
                }
            } else if (s.charAt(i + 1) != '0'){
                dp[i] = dp[i + 1];
            }
        }
        return dp[0] == 0 ? dp[1] : dp[0];
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("230"));
    }
}
