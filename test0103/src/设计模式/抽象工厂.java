package 设计模式;

public class 抽象工厂 {
}

//抽象工厂的目的是提供一个AbstractFactory抽象类，用户实例化对象的时候自己选择需要的工厂类型，用于创建相关的对象家族
/*public class AbstractProductA{}
public class AbstractProductB{}​

public class ProductA1 extends AbstractProductA{}
public class ProductA2 extends AbstractProductA{}​
public class ProductB1 extends AbstractProductB{}
public class ProductB2 extends AbstractProductB{}​​

public abstract class AbstractFactory{
    abstract  AbstractProductA  createProductA(){}​
    abstract  AbstractProductB  createProductB(){}​
}

public class Factory1 extends AbstractFactory{
    AbstractProductA  createProductA(){
        return new ProductA1();
    }
    AbstractProductB  createProductB(){
        return new ProductB1();​
    }
}

public class Factory2 extends AbstractFactory{
    AbstractProductA  createProductA(){
        return new ProductA2();
    }
    AbstractProductB  createProductB(){
        return new ProductB2();
    }
}
​
public class Client{
    public static void main(String[] args){
        AbstractFactory factory = new ​Factory1();        //自己选择实例化哪种工厂
        ​AbstractProductA = factory.createProductA();
​        AbstractProductB = factory.createProductB();​
    }
}*/