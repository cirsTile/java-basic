package factoryproduct;

import abstractfactory.Apple;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class ChinaApple extends Apple {
    @Override
    public void get() {
        System.out.println("中国苹果...");
    }
}
