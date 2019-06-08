package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-11-30 上午11:08
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, '0');
        num1 = reverse(num1);
        num2 = reverse(num2);
        int len1 = num1.length();
        int len2 = num2.length();
        // 表示进位
        int q = 0;
        for (int i = 0; i < len1; i++) {
            int p = num1.charAt(i) - '0';
            q = 0;
            int j;
            for (j = 0; j < len2; j++) {
                int temp = (result[j + i] - '0') +  (num2.charAt(j) - '0') * p + q;
                result[j + i] = (char) (temp % 10 + '0');
                q = temp / 10;
            }
            if (q != 0) {
                result[j + i] = (char) (q + '0');
            }
        }
        String reverse = reverse(String.valueOf(result));
        int index = -1;
        for (int i = 0; i < result.length; i++) {
            if (reverse.charAt(i) == '0') {
                index = i;
            } else  {
                break;
            }
        }
        reverse =  index == -1 ? reverse : reverse.substring(index + 1);
        return reverse.length() == 0 ? "0" : reverse;
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2", "4"));
    }
}
