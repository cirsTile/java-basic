package stack;

/**
 * @Description: 栈的实现
 * @Author: PanYi
 * @Date: 2022/7/20
 */

public class MyStack<T> {
    // 实现栈的数组
    private Object[] stackArray;
    // 数组中的元素个数
    private int size;

    // 构造方法，初始化数组
    public MyStack() {
        stackArray = new Object[10];
        size = 0;
    }

    public MyStack(int capacity) {
        stackArray = new Object[capacity];
        size = 0;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 判断栈是否满了
    public boolean isFull() {
        return this.size == stackArray.length;
    }

    // 进栈
    public void push(T t) {
        if (isFull()) {
            throw new RuntimeException("栈满了");
        }
        stackArray[size] = t;
        size++;
    }

    // 出栈
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空了");
        }
        T t = (T) stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        return t;
    }

}
