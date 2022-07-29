package stack;

import java.util.Stack;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/20
 */

public class StackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push("hello");
        myStack.push("world");
        myStack.push("java");

        String pop1 = (String) myStack.pop();
        System.out.println(pop1);
    }
}
