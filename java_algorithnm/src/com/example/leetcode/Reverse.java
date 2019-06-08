package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-10-29 上午9:24
 */
public class Reverse {

    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean flag = x < 0;
        x = flag ? Math.abs(x) : x;
        int y = 0;
        String xStr = String.valueOf(x);
        try {
            for (int i = xStr.length() - 1; i >= 0; i--) {
                if (y < Integer.MAX_VALUE && y > Integer.MAX_VALUE / 10) {
                    throw new RuntimeException();
                }
                y *= 10;
                y += Integer.parseInt(xStr.substring(i, i + 1));
            }
        } catch (RuntimeException te) {
            return 0;
        }
        return flag ? -y : y;
    }


}
