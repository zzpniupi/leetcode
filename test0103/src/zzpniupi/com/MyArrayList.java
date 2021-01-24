package zzpniupi.com;

public class MyArrayList {
    private Object[] ElementData;
    private int size;

    public MyArrayList(){
        ElementData = new Object[10];
    }

    public void add(Object obj){
        if(size >=  ElementData.length){
            Object[] temp = new Object[ElementData.length * 2];
            System.arraycopy(ElementData,0,temp,0,ElementData.length);
            ElementData = temp;
        }
        ElementData[size++] = obj;
    }
}
