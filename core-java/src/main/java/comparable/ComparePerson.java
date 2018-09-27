package comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparePerson {

    public static void main(String[] args) {
        final List<Person> personList = Arrays.asList(
            new ParcelMan("parcelMan", 20),
            new Postman("postman", 20));

        final Person max = Collections.max(personList);
    }
}
