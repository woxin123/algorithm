package com.example.剑指offer;

/**
 * 字符串转换为整数
 * @author mengchen
 * @time 19-4-16 上午9:01
 */
public class StrToInt {
    public int StrToInt(String str) {
        int flag = 1;
        int i = 0;
        if (str.startsWith("+")) {
            flag = 1;
            i++;
        } else if (str.startsWith("-")){
            flag = -1;
            i++;
        }
        long value = 0;

        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                value *= 10;
                value +=  flag * (ch - '0');

                if (flag == 1 && value > Integer.MAX_VALUE
                || flag == -1 && value < Integer.MIN_VALUE) {
                    value = 0;
                    break;
                }
            } else {
                return 0;
            }
        }
        return  (int) value;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("123"));
    }
}
