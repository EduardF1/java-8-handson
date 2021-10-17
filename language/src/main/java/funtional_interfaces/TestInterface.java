package funtional_interfaces;

@FunctionalInterface
public interface TestInterface {
    // abstract methods
    void add();

    // default method
    default String sayHi(){
        return "Hi";
    }

    static boolean isTrue() {
        return true;
    }
}
