package main;

import abstractfactory.FruitFactory;
import concretefactory.ChinaFactory;
import factorys.Fruit;

import java.util.*;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class MainInit {
    int a;
    public static void main(String[] args) {
        // 创建一个工厂
        FruitFactory chinaFactory = new ChinaFactory();
        // 创建一个苹果
        Fruit apple = chinaFactory.getApple();
        // 调用苹果的方法
        apple.get();
        // 创建一个香蕉
        Fruit banana = chinaFactory.getBanana();
        // 调用香蕉的方法
        banana.get();




    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums2;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        Set<Integer> array = new HashSet<>();
        for (int j : nums2) {
            if (hashSet.contains(j)) {
                array.add(j);
            }
        }
        return array.stream().mapToInt(Integer::intValue).toArray();
    }

    public void setA() {
        System.out.println(a+1);
    }
}
