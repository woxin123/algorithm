package com.example.剑指offer;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author mengchen
 * @time 19-4-9 下午5:01
 */
public class LastRemaining {

    static class Solution1 {
        public int LastRemaining_Solution(int n, int m) {
            if (n < 1 || m < 1) {
                return -1;
            }
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }

            ListIterator<Integer> iterator = list.listIterator();
            while (list.size() > 1) {
                for (int i = 0; i < m; i++) {
                    if (iterator.hasNext()) {
                        iterator.next();
                    } else {
                        iterator = list.listIterator();
                        iterator.next();
                    }
                }
                iterator.remove();
                if (!iterator.hasNext()) {
                    iterator = list.listIterator();
                }
            }
            return list.get(0);
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().LastRemaining_Solution(6, 7));
        }
    }

    static class Solution2 {
        public int LastRemaining_Solution(int n, int m) {
            if (n < 1 || m < 1) {
                return -1;
            }

            int last = 0;
            for (int i = 2; i <= n; i++) {
                last = (last + m) % i;
            }

            return last;
        }
    }

}
