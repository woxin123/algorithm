package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 逆波兰表达式求值
 * @author mengchen
 * @time 19-2-25 下午12:00
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String str : tokens) {
            if (!set.contains(str)) {
                num.push(Integer.valueOf(str));
            } else {
                int a = num.pop();
                int b = num.pop();
                char ch = str.charAt(0);
                switch (ch) {
                    case '+':
                        num.push(a + b);
                        break;
                    case '-':
                        num.push(a - b);
                        break;
                    case '*':
                        num.push(a * b);
                        break;
                    case '/':
                        num.push(a / b);
                        break;
                    default:

                }
            }
        }
        return num.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvalRPN().evalRPN(new String[] {"1", "2", "+"}));
    }
}
