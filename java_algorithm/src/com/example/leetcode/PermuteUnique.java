package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther 孟晨
 * @date 2019/1/8 16:01
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUniqueHelp(nums, new ArrayList<>(), 0, res);
        return res;
    }

    public void permuteUniqueHelp(int[] nums, List<Integer> list, int index, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add((List<Integer>) ((ArrayList) list).clone());
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i == index || !find(nums, index, i, nums[i])) {
                swap(nums, index, i);
                list.add(nums[index]);
                permuteUniqueHelp(nums, list, index + 1, result);
                list.remove(Integer.valueOf(nums[index]));
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private boolean find(int[] nums, int start, int end, int target) {
        for (int i = start; i < end; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        perm(list, nums, 0, nums.length - 1);
        return list;
    }

    public List<Integer> set(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }


    public void perm(List<List<Integer>> list, int[] nums, int L, int R) {
        if (L == R) {//只有一位的时候，直接set
            list.add(set(nums));
        } else {
            int i = L;
            while (i <= R) {
                int tmp = nums[i];
                int j = i;
                while (j < nums.length && nums[j] == tmp) {
                    j++;
                }
                swap(nums, L, i);//将第i个数放到第一位固定，然后去排后面的，这样就不用使用hash表来保存使用了多少数字，以及哪些数字没有使用了
                int[] a2 = nums.clone();
                perm(list, a2, L + 1, R);
                i = j;

            }
        }
        return;
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique1(new int[]{2, 2, 1, 1}));
    }

}
