package day02;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/6/29
 */

public class Test {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList();
        Dog dog = new Dog();
        dog.setDagName("小狗");
        Animal animal = new Animal();
        animal.setName("animal");
        list.add(dog);
        list.add(animal);
        list.forEach(System.out::println);
        System.out.println("===============================");

    }


    public  static <T> void print(T t){
        System.out.println(t);

    }
}
