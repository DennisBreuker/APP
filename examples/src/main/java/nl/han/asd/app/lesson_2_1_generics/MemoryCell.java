package nl.han.asd.app.lesson_2_1_generics;

public class MemoryCell<T> {

    private T storedValue;

    public T read() {
        return storedValue;
    }

    public void write (T x) {
        storedValue = x;
    }

}