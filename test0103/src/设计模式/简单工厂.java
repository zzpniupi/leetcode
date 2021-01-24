package 设计模式;

public class 简单工厂 {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Product product = factory.createProduct(1);
    }
}

interface Product{}

class Product1 implements Product{}

class Product2 implements Product{}

class Product3 implements Product{}

class SimpleFactory{
    public Product createProduct(int i){
        if(i == 1){
            return new Product1();
        }else if(i == 2){
            return new Product2();
        }else{
            return new Product3();
        }
    }
}