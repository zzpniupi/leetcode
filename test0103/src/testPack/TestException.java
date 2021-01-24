package testPack;

public class TestException {
    public static void main(String[] args){
/*        char ch = "hello".charAt(-1);
        int[] arr = {1,2,3};
        int a = arr[3];*/
        //ClassNotFound cnf = new ClassNotFound();
        //fun();
        fun2();
    }

    public static void fun() throws NullPointerException{
        throw new NullPointerException();
    }

    public static void fun2(){
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){

        }
    }
}
