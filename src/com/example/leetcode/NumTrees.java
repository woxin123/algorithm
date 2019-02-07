package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-7 下午10:33
 */
public class NumTrees {

    /**
     * 因为是1 2 3 4 5 6 ... n 而且因为是二叉搜索树，所以有如下规律
     * 规律： 1. 左子树节点个数=当前的i - 1，右字数节点个数n - i
     *       2. 以某一节点为根节点而形成的二叉搜索树的个数=左子树个数 * 右子树的个数
     * 举例： n = 1 1的二叉搜索数的个数为1
     *       n = 2 当以1为根节点时候，左子树的个数为0，右子树的个数为1，所以以1为根节点的时候结果是1
     *             当以2为根节点时候，左子树的个数为1，右子树的个数为0, 所以以2为根节点的时候结果是1
     *             所以n = 2的时候结果为1 + 1 = 2
     *       n = 3 当以1为根节点时候，左子树的个数为0，右子树的个数为2，所以以1为根节点的时候结果为2（1的右子树的节点是2 3和1 2的结果相同）
     *             当以2为根节点时候，左子树的个数为1，右子树的个数为1，所以以2为根节点的时候结果为1
     *             当以3为根节点时候，左子树的个数为2，右子树的个数为0，所以以2为根节点的时候结果为2（3的左子树的节点为1 2 ，所以结果为2）
     *             所以n = 2的时候结果为2 + 1 + 2 = 5
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(3));
    }

}
