package com.example.剑指offer;

public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        int size = sequence.length;
        if (size == 0) {
            return false;
        }
        return isLastOrder(sequence, 0, size - 1);

    }

    /**
     * 将树分为左右子树
     * @param sequence
     * @param b
     * @param e
     * @return
     */
    private boolean isLastOrder(int[] sequence, int b, int e) {
        if (b == e) {
            return true;
        }
        int mid = b;
        while (sequence[mid++] < sequence[e] && mid < e);

        int tmp = mid;

        while (sequence[tmp++] > sequence[e] && tmp < e);
        if (tmp < e) {
            return false;
        }

        if (mid == b || mid == e) {
            return isLastOrder(sequence, b ,e - 1);
        } else {
            return isLastOrder(sequence, b, mid - 1) && isLastOrder(sequence, mid, e - 1);
        }

    }
}
