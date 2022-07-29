package abstractfactory;

import factorys.Fruit;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public interface FruitFactory {
    // 实例化苹果
    Fruit getApple();
    // 实例化香蕉
    Fruit getBanana();
}
