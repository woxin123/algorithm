package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 18-11-16 下午3:06
 */
public class ConvertStringZ {


    /**
     * 模拟 内存爆了
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[][] indexs = new char[2000][2000];
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                indexs[i][j] = ' ';
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < numRows && i < s.length(); j++, i++) {
                indexs[x++][y] = s.charAt(i);
            }
            x = x - 2;
            y++;
            for (int j = 0; j < numRows - 2 && i < s.length(); j++, i++) {
                indexs[x--][y++] = s.charAt(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < y; j++) {
                if (indexs[i][j] != ' ') {
                    result.append(indexs[i][j]);
                }
            }
        }
        return result.toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public String covert3(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cyclen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cyclen) {
                ret.append(s.charAt(j + 1));
                if (i != 0 && i != numRows - 1 && j + cyclen - i < n) {
                    ret.append(s.charAt(j + cyclen - i));
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        ConvertStringZ z = new ConvertStringZ();
        String s = z.convert2("vqzunpjyavaewleuenzogfnztvyilyyjoxdbmobmmdtipzevmdjskwudusmhqmqgjvhxmkly", 43);
        System.out.println(s);
    }
}
