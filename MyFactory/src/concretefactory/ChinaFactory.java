package concretefactory;

import abstractfactory.FruitFactory;
import factoryproduct.ChinaApple;
import factoryproduct.ChinaBanana;
import factorys.Fruit;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/27
 */

public class ChinaFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new ChinaApple();
    }

    @Override
    public Fruit getBanana() {
        return new ChinaBanana();
    }
}

