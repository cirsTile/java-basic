package day03;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/30
 */

public class Day03 {
    public static void main(String[] args) {
        Day03 day03 = new Day03();
        int[] nums = {0};
        day03.removeElement(nums);
        System.out.println(Arrays.toString(nums));
    }


    public int removeElement(int[] nums){
        int flag = 0;
        int count = 0;
        int length = nums.length;
        for (int i=0;i<length;i++){
            if (nums[i] != 0){
                nums[flag] = nums[i];
                flag++;
            }else{
                count++;
            }
        }
        if (count != 0){
            for (int i=0;i<count;i++){
                nums[flag] = 0;
                flag++;
            }
        }
        return 0;
    }
}
