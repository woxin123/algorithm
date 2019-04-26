package com.example.剑指offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mengchen
 * @time 19-4-21 上午11:12
 */
public class FirstAppearingOnce {

    private char[] occurrence = new char[256];


    private char firstOccure = '#';

    private StringBuilder sb = new StringBuilder();


    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        occurrence[ch]++;
        if (occurrence[ch] > 1 && firstOccure == ch) {
            firstOccure = '#';
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (firstOccure != '#') {
            return firstOccure;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (occurrence[sb.charAt(i)] == 1) {
                firstOccure = sb.charAt(i);
                return firstOccure;
            }
        }
        return firstOccure;
    }

    public static void main(String[] args) {
        FirstAppearingOnce appearingOnce = new FirstAppearingOnce();
        String s = "google";
        for (int i = 0; i < s.length(); i++) {
            appearingOnce.Insert(s.charAt(i));
            System.out.print(appearingOnce.FirstAppearingOnce());

        }
    }

}
