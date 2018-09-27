package generics;

public interface Cloneable<T extends Cloneable<T>> {

    T clone();
}
