package com.fuyun.scala.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuyun on 2016/8/25.
 * 查找中位数
 * 存在时间复杂度为 O(log n)的解法 但是这里不是
 */
public class FindMedian {
    public static void main(String[] args) {
        FindMedian findMedian = new FindMedian();
        int[] test1 = {  };
        int[] test2 = { 2};

        System.out.println(findMedian.findMedianSortedArrays(test1, test2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i + j < nums1.length + nums2.length) {
            if (index(nums1, i) < index(nums2, j)) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        int medIndex = list.size() / 2;
        if (list.size() % 2 == 0) {
            return (list.get(medIndex - 1) + list.get(medIndex)) / 2d;
        } else {
            return list.get(medIndex);
        }
    }

    private int index(int[] nums, int index) {
        if (nums.length == 0 || nums.length == index) {
            return Integer.MAX_VALUE;
        } else {
            return nums[index];
        }
    }

}
