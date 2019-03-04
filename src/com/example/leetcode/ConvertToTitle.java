package com.example.leetcode;

/**
 * Excel表列名称
 * @author mengchen
 * @time 19-3-4 下午2:06
 */
public class ConvertToTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        n = n - 1;
        while (true) {
            int a = n / 26;
            if (a != 0 && a <= 26) {
                sb.append((char) (a + 'A' - 1));
            } else if (a > 26) {
                sb.append(convertToTitle(a));
            } else {
                sb.append((char) (n + 'A'));
                break;
            }
            n = n - a * 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(703));
    }

}
