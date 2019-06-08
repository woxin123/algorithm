package com.example.Main;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (Matching(s)) {
            System.out.println("匹配成功");
        }
        else
            System.out.println("失败");
    }

    static boolean Matching (String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.empty() || !leftAndRight(c, stack.pop()))
                    return false;
            }
        }
        return true;
    }

    private static boolean leftAndRight(char right, char left) {
        if (left == '(' && right == ')')
            return true;
        if (left == '[' && right == ']')
            return true;
        if (left == '{' && right == '}')
            return true;
        return false;
    }
}
