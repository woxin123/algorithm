package com.example.剑指offer;


/**
 * 求1+2+3+...+n
 * @author mengchen
 * @time 19-4-11 下午1:34
 */
public class Sum {

    static class Solution1 {
        public int Sum_Solution(int n) {
            int res = n;
            boolean b = (res != 0) && ((res += Sum_Solution(n - 1)) > 0);
            return res;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().Sum_Solution(100));
        }
    }

}
