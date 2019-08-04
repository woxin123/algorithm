package com.example.剑指offer;

import java.util.Scanner;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                str = str.deleteCharAt(i).insert(i, "%20");
                i = i + 2;
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuffer line = new StringBuffer(sc.nextLine());
            System.out.println(new ReplaceSpace().replaceSpace(line));
        }
    }
}
