package com.example.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 拼接数字
 */
public class StringIntMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list, (o1, o2) -> {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s2 + s1).compareTo(s1 + s2);
            });
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
        }
        System.out.println();
    }
}
