package comparable;

import java.util.Comparator;

public class ComparatorExample {

    public static void main(String[] args) {
        final Comparator<Person> comparator = Comparator.comparing(Person::age);
        final int compare = comparator.compare(new Person("me", 35), new Person("you", 34));
        System.out.println(compare);
    }
}
