package nl.han.asd.app.lesson4;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MemoryCell<Integer> m = new MemoryCell<Integer>();
        // De volgende twee aanroepen mogen nu niet, en falen tijdens compile-time:
//        m.write("Hallo");
//        m.write(new File("test"));

        m.write(42);

        // voorbeelden van compareTo()
        System.out.println("Cees".compareTo("Allard")); // moet > 0 zijn
        System.out.println("Cees".compareTo("Cees")); // moet 0 zijn
        System.out.println("Cees".compareTo("Cesco")); // moet < 0 zijn
    }
}
