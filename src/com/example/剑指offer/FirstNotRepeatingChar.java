package com.example.剑指offer;

/**
 * 第一个只出现一次的字符
 * @author mengchen
 * @time 19-3-31 上午10:01
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        int[] table = new int[256];
        for (int i = 0; i < str.length(); i++) {
            table[str.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (table[str.charAt(i)] == 1) {
                return count;
            }
            count++;
        }
        return -1;
    }

}
