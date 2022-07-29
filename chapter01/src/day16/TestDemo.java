package day16;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/29
 */

public class TestDemo {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        char[] array = s.toCharArray();
        int countSpace = 0;
        for(char c : array) {
            if (' ' == c) {
                countSpace++;
            }
        }
        if (countSpace == 0) {
            return s;
        }
        int len = array.length + (countSpace * 2);
        char[] newArray = new char[len];
        int flag = 0;
        for (int i = 0;i < array.length;i++){
            if (' ' == array[i]) {
                newArray[flag] = '%';
                newArray[++flag] = '2';
                newArray[++flag] = '0';
            } else {
                newArray[flag] = array[i];
            }
            flag++;
        }
        return new String(newArray);
    }
}
