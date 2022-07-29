package abstractfactory;

import factorys.Fruit;

/**
 * @Description: 使用抽象方法继承接口，可以不用实现接口的方法
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public abstract class Apple implements Fruit {
    public abstract void get();
}
