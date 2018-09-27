package comparable;

public class Person implements Comparable<Person> {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int age() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
