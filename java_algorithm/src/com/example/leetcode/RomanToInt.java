package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-11-20 下午2:56
 */
public class RomanToInt {

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            }
            if (s.charAt(i) == 'D') {
                result += 500;
            }
            if (s.charAt(i) == 'C') {
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                    } else if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                    } else {
                        result += 100;
                    }
                } else {
                    result += 100;
                }
            }
            if (s.charAt(i) == 'L') {
                result += 50;
            }
            if (s.charAt(i) == 'X') {
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                    } else if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
            }
            if (s.charAt(i) == 'V') {
                result += 5;
            }
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                    } else if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                    } else {
                        result += 1;
                    }
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }

}
