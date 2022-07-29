package day01;

/**
 * @Description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @Author: PanYi
 * @Date: 2022/6/28
 */

public class Solution01 {
    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int length = solution01.removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val){
        int fast = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                nums[fast] = nums[i];
                fast++;
            }
        }
        return fast;
    }
}
