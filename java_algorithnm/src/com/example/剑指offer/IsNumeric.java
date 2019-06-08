package com.example.剑指offer;

/**
 * @author mengchen
 * @time 19-4-21 上午11:45
 */
public class IsNumeric {

    public boolean isNumeric(char[] str) {
        int index = 0;
        if (str[0] == '+' || str[0] == '-') {
            index++;
        }

        boolean isNumeric = true;
        index = scanDigits(str, index);
        if (index < str.length) {
            if (str[index] == '.') {
                index++;
                index = scanDigits(str, index);
                if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
                    return isExponential(str, index);
                }
            } else if (str[index] == 'e' || str[index] == 'E') {
                return isExponential(str, index);
            } else {
                isNumeric = false;
            }

        }
        return isNumeric && index == str.length;
    }

    private int scanDigits(char[] str, int index) {
        while (index < str.length && Character.isDigit(str[index])) {
            index++;
        }
        return index;
    }

    private boolean isExponential(char[] str, int index) {
        if (str[index] != 'e' && str[index] != 'E') {
            return false;
        }
        index++;

        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        if (index == str.length) {
            return false;
        }
        index = scanDigits(str, index);

        return index == str.length;

    }

    public static void main(String[] args) {
        new IsNumeric().isNumeric("3.1415".toCharArray());
    }

}
