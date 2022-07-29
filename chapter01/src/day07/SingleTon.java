package day07;

/**
 * @Description: 线程安全的单例模式
 * @Author: PanYi
 * @Date: 2022/7/6
 */

public class SingleTon {

    // 使用volatile关键字保证线程安全，防止指令重排序
    private static volatile SingleTon instance = null;
    private String name;
    private int age;

    private SingleTon(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public static SingleTon getInstance(String name, int age) {
        if (instance == null){
            synchronized (SingleTon.class){
                if (instance == null){
                    instance = new SingleTon(name, age);
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SingleTon{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
