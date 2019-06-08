package com.example.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.Permutation1("abc".toString()));
    }

    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            Permutation1Help(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void Permutation1Help(char[] str, int i, List<String> list) {
        if (i == str.length - 1) {
            String val = String.valueOf(str);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);    // 换位
                Permutation1Help(str, i + 1, list);
                swap(str, i, j);    // 再换回来
            }
        }
    }

    private void swap(char str[], int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
