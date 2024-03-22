package StrukturData.Modul1.codelab;

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();

        integerBox.setValue(42);
        int intValue = integerBox.getValue();
        System.out.println("Interger value: " + intValue);

        Box<String> stringBox = new Box<>();

        stringBox.setValue("hello, Generics!");
        String strValue = stringBox.getValue();
        System.out.println("string value: " + strValue);

    }
}
