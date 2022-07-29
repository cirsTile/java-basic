package day04;

import java.util.Arrays;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/1
 */

public class ArrayDay04 {
    public static void main(String[] args){
        int[] number = {-2,0};
        int[] ints = sortedSquares(number);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] sortedSquares(int[] nums) {
        int forward = -1;
        int backward = -1;
        int length = nums.length;
        int result[] = new int[length];
        for (int i=0;i < length;i++){
            if (nums[i] >= 0){
                forward = i;
                backward = i;
                break;
            }
        }
        // 全部都是正数
        if (forward == 0){
            for (int i=0;i<length;i++){
                result[i] = nums[i] * nums[i];
            }
            return result;
        }
        // 全部都是负数
        if (forward == -1){
            forward = 0;
            for (int i = length - 1;i>=0;i--){
                result[forward] = nums[i] * nums[i];
                forward++;
            }
            return result;
        }
        int flag = 0;
        int value = 0;
        while (forward < length || backward >= 0){
            if (nums[forward] * nums[forward] < nums[backward - 1] * nums[backward -1]){
                result[flag] = nums[forward] * nums[forward];
                forward++;
            }else{
                result[forward] = nums[backward] * nums[backward];
                backward--;
            }
            flag++;
        }
        return result;
    }
}
