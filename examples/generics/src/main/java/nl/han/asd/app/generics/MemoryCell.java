import java.util.ArrayList;

class Other {
    public static <AnyType extends Comparable<? super AnyType>>
    AnyType min(AnyType[] arr) {
        AnyType min = arr[0];
        for (AnyType a : arr) {
            if (a.compareTo(min) < 0) {
                min = a;
            }
        }

        return min;
    }

    //ArrayList version
    public static <AnyType extends Comparable<? super AnyType>>
    AnyType min(ArrayList<AnyType> arr) {
        AnyType min = arr.get(0);
        for (AnyType a : arr) {
            if (a.compareTo(min) < 0) {
                min = a;
            }
        }

        return min;
    }
}

class MemoryCell<T extends Comparable<? super T>>
        implements Comparable<MemoryCell<T>> {
    private T value;

    public T read() {
        return value;
    }

    public void write(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(MemoryCell<T> o) {

        return value.compareTo(o.read());
    }

    public String toString() {
        return value.toString();
    }

    public static void main(String[] arg) {
        MemoryCell<String> a = new MemoryCell<String>();
        MemoryCell<String> b = new MemoryCell<String>();
        MemoryCell<String> c = new MemoryCell<String>();

        a.write("a");
        b.write("b");
        c.write("c");

        // Array Version, geeft wat problemen zie ook:
        // http://stackoverflow.com/questions/14917375/cannot-create-generic-array-of-how-to-create-an-array-of-mapstring-obje
        // Daarom moeten we een Raw Type gebruiken, warnings kunnen niet verdwijnen:
        MemoryCell input[] = {c, b, a};
        MemoryCell<String> res = Other.min(input);
        System.out.println(res);

        // ArrayList version, geeft geen problemen:
        ArrayList<MemoryCell> inputList = new ArrayList<MemoryCell>();
        inputList.add(a);
        inputList.add(b);
        inputList.add(c);

        MemoryCell<String> res2 = Other.min(inputList);
        System.out.println(res2);
    }
}