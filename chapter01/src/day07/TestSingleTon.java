package day07;

import static java.lang.Thread.sleep;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/6
 */

public class TestSingleTon {

    public static void main(String[] args) {
//        SingleTon singleTon = SingleTon.getInstance("PanYi", 18);
//        System.out.println(singleTon.toString());
        // 多线程环境下，可能会出现多个实例
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                SingleTon singleTon = SingleTon.getInstance("PanYi", 19);
                System.out.println(singleTon.toString());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingleTon singleTon = SingleTon.getInstance("PanYi", 20);
                System.out.println(singleTon.toString());
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingleTon singleTon = SingleTon.getInstance("PanYi", 21);
                System.out.println(singleTon.toString());
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
