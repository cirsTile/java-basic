package day15;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/25
 */

public class MyString {
    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(reverseStr(a,2));
    }

    public static String reverseStr(String s, int k) {

        char[] sToChar = s.toCharArray();
        int len = s.length();
        char flag;
        for (int i=0;i<len;i += (2 * k)) {
            int j = Math.min(i + k - 1, len - 1);
            int start = i;
            int end = j;
            while (start < j) {
                flag = sToChar[end];
                sToChar[end] = sToChar[start];
                sToChar[start] = flag;
                start++;
                end--;
            }
        }
        return new String(sToChar);
    }


}
