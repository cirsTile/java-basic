package factoryproduct;

import factorys.Fruit;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class ChinaBanana implements Fruit {
    @Override
    public void get() {
        System.out.println("中国香蕉...");
    }
}

