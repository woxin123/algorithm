package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-11-19 下午6:51
 */
public class IntToRom {

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int[] limits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        if (num <= 0) {
            return null;
        } else {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < limits.length && num > 0; i++) {
                if (num >= limits[i]) {
                    sb.append(map.get(limits[i]));
                    num = num - limits[i];
                    if (num >= limits[i]) {
                        i--;
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        IntToRom intToRom = new IntToRom();
        System.out.println(intToRom.intToRoman(1994));
    }

}
