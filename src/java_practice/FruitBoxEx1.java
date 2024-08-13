package java_practice;

import java.io.File;
import java.util.ArrayList;

class Fruit{

    String name;

    Fruit(String name){
        this.name = name;
    }

    public String toString(){
        return "fruit";
    }
}

class Apple extends Fruit{

    Apple(){
        super("apple");
    }

    public String toString(){
        return this.name;
    }
}

class WaterMelon extends Fruit{

    WaterMelon(){
        super("apple");
    }

    public String toString(){
        return this.name;
    }
}

class Toy{
    public String toString(){
        return "Toy";
    }
}

class Box<T>{
    ArrayList<T> boxList = new ArrayList<>();
    public void add(T item){
        boxList.add(item);
    }
    public T get(int i){
        return boxList.get(i);
    }

    public int size(){
        return boxList.size();
    }

    public String toString(){
        return boxList.toString();
    }
}



public class FruitBoxEx1 {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<WaterMelon> waterMelonBox = new Box<>();
        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit("fruit"));
        fruitBox.add(new Apple());
        fruitBox.add(new WaterMelon());

        System.out.println(fruitBox);

        StringBuffer stringBuffer = new StringBuffer();

    }

}
