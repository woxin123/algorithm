package com.example.剑指offer;

/**
 * 翻转单词顺序列
 * @author mengchen
 * @time 19-4-6 上午11:42
 */
public class ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        if (!str.contains(" ")) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();

        int length = str.length();
        int start = 0, end = 0;
        while (start < length) {
            if (sb.charAt(start) == ' ') {
                start++;
                end++;
            } else if (sb.charAt(end) == ' ' || end == length - 1) {
                if (start != end && end == length - 1) {
                    end++;
                }
                sb = sb.replace(start, end, new StringBuilder(sb.substring(start, end)).reverse().toString());
                start = ++end;
            } else {
                end++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().ReverseSentence("I am a student."));
    }

}
