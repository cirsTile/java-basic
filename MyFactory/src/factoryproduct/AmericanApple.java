package factoryproduct;

import abstractfactory.Apple;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class AmericanApple extends Apple {
    @Override
    public void get() {
        System.out.println("美国苹果...");
    }
}

