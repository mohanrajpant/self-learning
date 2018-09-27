package generics;

public class ConfusedPerson2 implements Cloneable<ConfusedPerson2> {

    private final String name;

    public ConfusedPerson2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public ConfusedPerson2 clone() {
        return new ConfusedPerson2(getName());
    }
}
