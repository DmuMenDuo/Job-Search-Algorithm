package me.menduo.junitDesDemo;

public class Demo {

    @Test
    public void sayHello() {
        System.out.println("hello1~");
    }

    public void sayEatting() {
        System.out.println("eatting");
    }

    @Test
    @ExceptionTest(NullPointerException.class)
    @ExceptionTest(IndexOutOfBoundsException.class)
    public void sayByeing() {
        System.out.println("bye~");
        int[] a = {1};
        System.out.println(a[2]);
        throw new NullPointerException();
    }
}
