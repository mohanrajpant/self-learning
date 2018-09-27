package generics;

public class ConfusedPerson1 implements Cloneable<ConfusedPerson1> {

    private final String name;

    public ConfusedPerson1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public ConfusedPerson1 clone() {
        return new ConfusedPerson1(getName());
    }
}
