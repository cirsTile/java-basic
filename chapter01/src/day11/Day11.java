package day11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/14
 */

// 有效的字母异位词
public class Day11 {

    public static void main(String[] args) {
        System.out.println(Day11.isAnagram("rat", "cat"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = s.toCharArray();
        if (sArray.length != tArray.length) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : sArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character c : tArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, -1);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
