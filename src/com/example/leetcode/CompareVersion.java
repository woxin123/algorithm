package com.example.leetcode;

/**
 * 比较版本号
 *
 * @author mengchen
 * @time 19-3-2 下午2:45
 */
public class CompareVersion {

    /**
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int num1 = 0;
        int num2 = 0;
        int v1 = 0, v2 = 0;
        while (v1 < version1.length() || v2 < version2.length()) {
            while (v1 < version1.length() && version1.charAt(v1) != '.') {
                num1 = num1 * 10 + (version1.charAt(v1) - '0');
                v1++;
            }

            while (v2 < version2.length() && version2.charAt(v2) != '.') {
                num2 = num2 * 10 + (version2.charAt(v2) - '0');
                v2++;
            }

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            num1 = 0;
            num2 = 0;
            v1++;
            v2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("0.1", "1.0"));
    }
}
