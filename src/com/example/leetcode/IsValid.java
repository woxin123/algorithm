package com.example.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author mengchen
 * @time 18-11-25 下午11:01
 */
public class IsValid {

    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (ch == ')') {

                if (stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("{}][}}{[))){}{}){(}]))})[({"));
    }

}
