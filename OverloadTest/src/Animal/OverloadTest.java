package Animal;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/15
 */

public class OverloadTest {
    public static void main(String[] args) {
        show(new Dog());
        show(new Cat());

        // 向上转型
        Animal animal = new Cat();
        animal.eat();

        // 向下转型
        Cat cat = (Cat) animal;
        cat.work();
    }


    public static void show(Animal animal) {
        animal.eat();
        // 类型判断
        if (animal instanceof Dog) {
            ((Dog) animal).work();
        }
        if (animal instanceof Cat){
            ((Cat) animal).work();
        }
    }
}
