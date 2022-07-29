package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二分查找
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class DebugArrayList {
    public static void main(String[] args) {
        DebugArrayList debugArrayList = new DebugArrayList();
        int search = debugArrayList.search(new int[]{}, 5);
        System.out.println(search);
    }

    // 二分查找
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
