package be.intecbrussel.sellers;

public class NoMoreIceCreamException extends Exception{

    public NoMoreIceCreamException() {
        this("No more Ice Cream");
    }

    public NoMoreIceCreamException(String string) {
        super(string);
    }
}
