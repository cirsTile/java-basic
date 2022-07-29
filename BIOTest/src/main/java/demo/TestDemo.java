package demo;

import java.util.Arrays;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/19
 */

public class TestDemo {
    public static void main(String[] args) {
        String a = "10000";
        String[] b = a.split(",");
        int[] c = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] = Integer.parseInt(b[i]);
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
            if (i != c.length - 1) {
                sb.append(",");
            }
        }
        String d = sb.toString();
        System.out.println(sb.toString());
    }
}
