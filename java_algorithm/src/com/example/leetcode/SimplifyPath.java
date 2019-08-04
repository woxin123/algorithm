package com.example.leetcode;

import java.util.LinkedList;

/**
 * @author mengchen
 * @time 18-11-28 下午1:50
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".")) {
                continue;
            } else if (strs[i].equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else if (strs[i].length() > 0) {
                stack.push(strs[i]);
            } else {
                continue;
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0 ; i--) {
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
    }
}
