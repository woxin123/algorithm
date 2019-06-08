package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-1-27 下午5:50
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        int[] sum = new int[max + 1];
        int tmp = 0;
        int p = a.length() - 1;
        int q = b.length() - 1;
        int i;
        for (i = 0; i < max; i++) {
            int x = p >= 0 ? a.charAt(p--) - '0' : 0;
            int y = q >= 0 ? b.charAt(q--) - '0' : 0;
            int z = x + y + tmp;
            tmp = z / 2;
            sum[i] = z % 2;
        }
        if (tmp != 0) {
            sum[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        int n = sum[max] == 0 ? max - 1 : max;
        for (int j = n; j >= 0; j--) {
            sb.append(sum[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }
}
